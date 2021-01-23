package br.com.andrade.product.response;

import java.time.LocalDate;
import java.util.List;

import br.com.andrade.product.entity.Product;
import lombok.Data;

@Data
public class ProductSearchResponse {
	
	private LocalDate correntDate;
	private List<String> searchTerms;
	private String message;
	private List<Product> products;

	public ProductSearchResponse() {
		this.correntDate = LocalDate.now();
	}

	public ProductSearchResponse(List<String> searchTerms, List<Product> products) {
		this.correntDate = LocalDate.now();
		this.searchTerms = searchTerms;
		this.products = products;
	}
	
	public ProductSearchResponse(List<String> searchTerms, List<Product> products, String message) {
		this.searchTerms = searchTerms;
		this.products = products;
		this.message = message;
	}
	
	public ProductSearchResponse(List<Product> products, String message) {
		this.products = products;
		this.message = message;
	}
}
