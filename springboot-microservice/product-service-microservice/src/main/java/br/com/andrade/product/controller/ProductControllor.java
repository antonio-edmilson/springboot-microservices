package br.com.andrade.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrade.product.entity.Product;
import br.com.andrade.product.request.ProductRequest;
import br.com.andrade.product.response.ProductResponse;
import br.com.andrade.product.service.ProductService;

@RestController
@RequestMapping(value = "/v1/product")
public class ProductControllor {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<String> findAll(){
		return ResponseEntity.ok("teste");
	}
	
	public Product save(@RequestBody ProductRequest productRequest) {
		return productService.save(ProductRequest.parseProduct(productRequest));
	}

}
