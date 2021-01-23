package br.com.andrade.product.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.andrade.product.entity.Product;
import br.com.andrade.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ApiSaleService apiSaleService;
	
	@Autowired
	private ApiProductNoteService apiProductNoteService;
	
	@Autowired
	private ApiProductCategoryService apiProductCategoryService;

	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public Product update(Product product) {
		if(product != null) {
			return productRepository.save(product);
		}
		return null;
	}
	
	public Product updateScore(Long idProduct, Double score) {
		Product product = this.findById(idProduct);
		if(product != null) {
			product.setScore(score);
			return productRepository.save(product);
		}
		return null;
	}
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		return productRepository.findById(id).stream().findFirst().orElse(null);
	}
	
	public List<Product> findByExampleOrderScoreNameCategory(Product productExample) {
		Example<Product> example = Example.of(productExample);
		return groupByResultSearchProduct(productRepository.findAll(example));
	}

	private List<Product> groupByResultSearchProduct(List<Product> result) {
		List<Product> listProduct = new ArrayList<>();
		result.forEach(p -> p.setScore(this.calculateScore(p.getId(), p.getCategory())));
		Map<Object, List<Product>> resultGroupBy = result.stream().collect(Collectors.groupingBy(g-> Arrays.asList(g.getScore(), g.getName(), g.getCategory())));
		resultGroupBy.forEach((k,v) -> listProduct.addAll(v));
		return listProduct;
	}

	public void delete(Long id) {
		productRepository.deleteById(id);
	}
	
	private Double getQuantitiesExistsProduct(Long idProduct) {
		Product product = productRepository.getOne(idProduct);
		Long quantityDaysExists = product.getCreationDate().until(LocalDate.now(), ChronoUnit.DAYS);
		Long quantitySales = apiSaleService.getAmountSalesByProduct(idProduct);
		return quantitySales.equals(0) && !quantityDaysExists.equals(0) ? Long.divideUnsigned(quantitySales, quantityDaysExists) : 0.0;
	}
	
	private Double calculateScore(Long idProduct, String category) {
		Double averageNoteProductX = apiProductNoteService.getAverageNoteProduct(idProduct);
		Double quantityDaysY = this.getQuantitiesExistsProduct(idProduct);
		Integer amountNewsByCategoryZ = apiProductCategoryService.getAmountNewsByCategory(category);
		return averageNoteProductX + quantityDaysY + amountNewsByCategoryZ;
	}
}
