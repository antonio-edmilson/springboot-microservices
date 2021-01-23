package br.com.andrade.product.request;

import javax.validation.constraints.NotNull;

import br.com.andrade.product.entity.Product;
import lombok.Data;

@Data
public class ProductScoreRequest {
	
	@NotNull(message = "Required to enter a Id value")
	private Long id;
	
	@NotNull(message = "Required to enter a Score value")
	private Double score;
	
	public final static Product parseProduct(Product product, ProductScoreRequest productScoreRequest) {
		if(product == null){
			return null;
		}
		product.setScore(productScoreRequest.getScore());
		return product;
	}
	
}
