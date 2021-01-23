package br.com.andrade.salesman.response;

import br.com.andrade.salesman.entity.Salesman;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesmanResponse {
	
	private Salesman salesman;
	
	private String message;

}
