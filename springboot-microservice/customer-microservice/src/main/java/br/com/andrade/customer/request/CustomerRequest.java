package br.com.andrade.customer.request;

import javax.validation.constraints.NotNull;

import br.com.andrade.customer.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
	
	@NotNull(message = "Required to enter a name value")
	private String name;
	
	@NotNull(message = "Required to enter a login value")
	private String login;
	
	@NotNull(message = "Required to enter a password value")
	private String password;
	
	@NotNull(message = "Required to enter a address value")
	private String address;
	
	public final static Customer parserCustomer(CustomerRequest customerRequest) {
		return new Customer(null, customerRequest.getName(), customerRequest.getLogin(), customerRequest.getPassword(), customerRequest.getAddress());
	}

}
