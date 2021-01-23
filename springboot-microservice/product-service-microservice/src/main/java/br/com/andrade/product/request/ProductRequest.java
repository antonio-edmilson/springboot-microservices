package br.com.andrade.product.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.andrade.product.entity.Product;
import lombok.Data;

@Data
public class ProductRequest {
	
	@NotBlank(message = "Required to enter a name value")
	private String name;
	
	@NotBlank(message = "Required to enter a description value")
	private String description;
	
	@NotNull(message = "Required to enter a category value")
	private String category;
	
	@NotNull(message = "Required to enter a price value")
	private BigDecimal price;
	
	public final static Product parseProduct(ProductRequest productRequest) {
		return new Product(productRequest.getName(), productRequest.getDescription(), productRequest.getCategory(), productRequest.getPrice());
	}
	
}
