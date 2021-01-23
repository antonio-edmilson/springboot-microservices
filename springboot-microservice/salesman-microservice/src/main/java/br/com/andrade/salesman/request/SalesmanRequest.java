package br.com.andrade.salesman.request;

import javax.validation.constraints.NotNull;

import br.com.andrade.salesman.entity.Salesman;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesmanRequest {
	
	@NotNull(message = "Required to enter a name value")
	private String name;
	
	@NotNull(message = "Required to enter a login value")
	private String login;
	
	@NotNull(message = "Required to enter a password value")
	private String password;
	
	public final static Salesman parserCustomer(SalesmanRequest salesmanRequest) {
		return new Salesman(null, salesmanRequest.getName(), salesmanRequest.getLogin(), salesmanRequest.getPassword());
	}

}
