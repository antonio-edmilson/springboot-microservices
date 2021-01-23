package br.com.andrade.salesman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andrade.salesman.entity.Salesman;
import br.com.andrade.salesman.repository.SalesmanRepository;

@Service
public class SalesmanService {

	@Autowired
	private SalesmanRepository salesmanRepository;

	public Salesman save(Salesman salesman) {
		return salesmanRepository.save(salesman);
	}
	
	public List<Salesman> findAll() {
		return salesmanRepository.findAll();
	}
	
}
