package br.com.andrade.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.andrade.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
