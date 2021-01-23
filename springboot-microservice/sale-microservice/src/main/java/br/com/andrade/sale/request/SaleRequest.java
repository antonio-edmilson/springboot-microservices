package br.com.andrade.sale.request;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import br.com.andrade.sale.entity.Sale;
import br.com.andrade.sale.entity.Selles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleRequest {
	
	@NotNull(message = "Required to enter a idSalesman value")
	private Long idSalesman;
	
	@NotNull(message = "Required to enter a idCustomer value")
	private Long idCustomer;
	
	@NotNull(message = "Required to enter a sellesRequest value")
	private List<SellesRequest> selles;
	
	public final static Sale parserSale(SaleRequest saleRequest) {
		List<Selles> selles = saleRequest.getSelles().stream().map(s -> new Selles(null, s.getIdProduct(), s.getPrice(), null)).collect(Collectors.toList());
		return new Sale(saleRequest.getIdSalesman(), saleRequest.getIdCustomer(), selles);
	}
}
