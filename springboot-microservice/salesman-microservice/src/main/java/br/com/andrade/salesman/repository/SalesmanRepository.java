package br.com.andrade.salesman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.andrade.salesman.entity.Salesman;

@Repository
public interface SalesmanRepository extends JpaRepository<Salesman, Long> {
	
}
