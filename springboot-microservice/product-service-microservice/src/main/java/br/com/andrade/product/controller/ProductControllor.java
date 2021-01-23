package br.com.andrade.product.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrade.product.entity.Product;
import br.com.andrade.product.exception.CustomExceptionHandler;
import br.com.andrade.product.request.ProductRequest;
import br.com.andrade.product.request.ProductSearchRequest;
import br.com.andrade.product.request.ProductUpdateRequest;
import br.com.andrade.product.response.ProductResponse;
import br.com.andrade.product.response.ProductSearchResponse;
import br.com.andrade.product.service.ProductService;

@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductControllor extends CustomExceptionHandler {

	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest productRequest) {
		Product product = productService.save(ProductRequest.parseProduct(productRequest));
		return ResponseEntity.ok(new ProductResponse(product, "Product successfully created"));
	}

	@PutMapping
	public ResponseEntity<ProductResponse> update(@Valid @RequestBody ProductUpdateRequest productUpdateRequest) {
		Product productFind = productService.findById(productUpdateRequest.getId());
		Product product = productService.update(ProductUpdateRequest.parseProduct(productFind, productUpdateRequest));
		return ResponseEntity.ok(new ProductResponse(product,
				product != null ? "Product successfully updated" : "No product in the database"));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(value = "id") Long id){
		productService.delete(id);
		return ResponseEntity.ok("Product successfully deleted.");
	}

	@GetMapping
	public ResponseEntity<ProductSearchResponse> findByExampleOrderScoreNameCategory(@RequestParam(value="name", required = false) String name, @RequestParam(value="category", required = false) String category, @RequestParam(value="score", required = false) Double score){
		ProductSearchRequest request = new ProductSearchRequest(name, score, category);
		List<Product> products = productService.findByExampleOrderScoreNameCategory(ProductSearchRequest.parseProduct(request));
		return ResponseEntity.ok(new ProductSearchResponse(this.searchTerms(request), sortedProducts(products)));
	}

	private List<Product> sortedProducts(List<Product> products) {
		return products.stream().sorted(Comparator.comparingDouble(Product::getScore).reversed().thenComparing(Comparator.comparing(Product::getName)).thenComparing(Comparator.comparing(Product::getCategory))).collect(Collectors.toList());
	}
	
	@GetMapping("/findBy")
	public ResponseEntity<Product> findBy(@RequestParam(value="idproduct") Long idproduct){
		Product products = productService.findById(idproduct);
		return ResponseEntity.ok(products);
	}
	
	private List<String> searchTerms(ProductSearchRequest request){
		List<String> filtersCriterion = new ArrayList<>();
		if(request.getName() != null) {
			filtersCriterion.add("name");
		}
		if(request.getScore() != null) {
			filtersCriterion.add("score");
		}
		if(request.getCategory() != null) {
			filtersCriterion.add("category");
		}
		return filtersCriterion;
	}
	
}
