package br.com.andrade.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.andrade.customer.entity.Customer;

@Repository
public interface CostumerRepository extends JpaRepository<Customer, Long> {
	
}
