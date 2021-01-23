package br.com.andrade.sale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.andrade.sale.entity.Selles;

@Repository
public interface SellesRepository extends JpaRepository<Selles, Long> {
	
}
