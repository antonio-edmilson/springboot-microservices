package br.com.andrade.sale.request;

import java.math.BigDecimal;

import br.com.andrade.sale.entity.Selles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellesRequest {
	
	private Long idProduct;
	private BigDecimal price;
	
	public final static Selles parserSale(SellesRequest sellsRequest) {
		return new Selles(null, sellsRequest.getIdProduct(), sellsRequest.getPrice(), null);
	}
}
