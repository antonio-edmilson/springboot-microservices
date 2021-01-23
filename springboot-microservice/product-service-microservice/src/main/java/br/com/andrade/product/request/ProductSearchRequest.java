package br.com.andrade.product.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.andrade.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSearchRequest {
	
	@NotBlank(message = "Required to enter a name value")
	private String name;
	
	@NotBlank(message = "Required to enter a description value")
	private Double score;
	
	@NotNull(message = "Required to enter a category value")
	private String category;
	
	public final static Product parseProduct(ProductSearchRequest productRequest) {
		return new Product(productRequest.getName(),  productRequest.getCategory(), productRequest.getScore());
	}
	
}
