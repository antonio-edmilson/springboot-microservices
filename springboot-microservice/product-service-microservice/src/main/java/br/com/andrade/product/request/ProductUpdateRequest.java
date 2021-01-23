package br.com.andrade.product.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;

import br.com.andrade.product.entity.Product;
import lombok.Data;

@Data
public class ProductUpdateRequest {
	
	@NotNull(message = "Required to enter a Id value")
	private Long id;
	
	private String name;
	private String description;
	private BigDecimal price;
	private String category;
	
	public final static Product parseProduct(Product product, ProductUpdateRequest productUpdateRequest) {
		if(product == null){
			return null;
		}
		
		if(StringUtils.isNotBlank(productUpdateRequest.getName())) {
			product.setName(productUpdateRequest.getName());
		}
		if(StringUtils.isNotBlank(productUpdateRequest.getDescription())) {
			product.setDescription(productUpdateRequest.getDescription());
		}
		if(productUpdateRequest.getPrice() != null) {
			product.setPrice(productUpdateRequest.getPrice());
		}
		if(StringUtils.isNotBlank(productUpdateRequest.getCategory())) {
			product.setCategory(productUpdateRequest.getCategory());
		}
		return product;
	}
	
}
