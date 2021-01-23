package br.com.andrade.customer.response;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCreateResponse {

	private Long id;

	private String name;

	private String login;

	private String address;

	private String message;

}
