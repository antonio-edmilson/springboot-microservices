package br.com.andrade.customer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrade.customer.entity.Customer;
import br.com.andrade.customer.request.CustomerRequest;
import br.com.andrade.customer.response.CustomerCreateResponse;
import br.com.andrade.customer.service.CustomerService;

@RestController
@RequestMapping(value = "/api/v1/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<CustomerCreateResponse> create(@Valid @RequestBody CustomerRequest customerRequest) {
		Customer customer = customerService.save(CustomerRequest.parserCustomer(customerRequest));
		return ResponseEntity.ok(new CustomerCreateResponse(customer.getId(), customer.getName(), customer.getLogin(), customer.getAddress(), " Customer successfully created"));
	}

}
