package br.com.andrade.sale.response;

import br.com.andrade.sale.entity.Sale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleResponse {
	
	private Sale sale;
	
	private String message;

}
