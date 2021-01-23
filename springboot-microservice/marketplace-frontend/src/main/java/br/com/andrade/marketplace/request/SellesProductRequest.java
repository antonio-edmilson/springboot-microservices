package br.com.andrade.marketplace.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellesProductRequest {
	
	private Long idProduct;
	
	private BigDecimal price;
	
}
