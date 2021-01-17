package br.com.andrade.product.request;

import java.time.LocalDate;

import br.com.andrade.product.entity.Product;
import lombok.Data;

@Data
public class ProductRequest {
	
	private String name;
	private String description;
	private LocalDate creationDate;
	
	public final static Product parseProduct(ProductRequest productRequest) {
		return new Product(productRequest.getName(), productRequest.getDescription());
	}
	
}
