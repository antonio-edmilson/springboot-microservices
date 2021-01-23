package br.com.andrade.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andrade.customer.entity.Customer;
import br.com.andrade.customer.repository.CostumerRepository;

@Service
public class CustomerService {

	@Autowired
	private CostumerRepository costumerRepository;

	public Customer save(Customer customer) {
		return costumerRepository.save(customer);
	}
	
	public List<Customer> findAll() {
		return costumerRepository.findAll();
	}
	
	
}
