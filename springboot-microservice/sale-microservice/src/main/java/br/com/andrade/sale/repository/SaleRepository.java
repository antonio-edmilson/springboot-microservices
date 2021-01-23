package br.com.andrade.sale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.andrade.sale.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
	
}
