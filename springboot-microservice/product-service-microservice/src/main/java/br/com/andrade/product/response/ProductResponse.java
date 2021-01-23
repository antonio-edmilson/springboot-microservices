package br.com.andrade.product.response;

import br.com.andrade.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
	
	private Product product;
	private String message;

}
