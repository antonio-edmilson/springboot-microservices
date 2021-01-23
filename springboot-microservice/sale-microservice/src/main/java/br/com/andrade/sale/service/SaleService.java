package br.com.andrade.sale.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.andrade.sale.entity.Sale;
import br.com.andrade.sale.entity.Selles;
import br.com.andrade.sale.repository.SaleRepository;
import br.com.andrade.sale.repository.SellesRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private SellesRepository sellesRepository;

	public Sale save(Sale sale) {
		Sale saleDb = saleRepository.save(sale);
		List<Selles> sallesDb = new ArrayList<>();
		sale.getSelles().forEach(ss -> {
			ss.setSale(saleDb);
			sallesDb.add(sellesRepository.save(ss));
		});
		saleDb.setSelles(sallesDb);
		return saleDb;
	}
	
	public List<Sale> findAll() {
		return saleRepository.findAll();
	}
	
	public Long getAmountSalesByProduct(Long idProduct) {
		Selles saleExample = new Selles();
		saleExample.setIdProduct(idProduct);
		return sellesRepository.count(Example.of(saleExample));
	}
	
}
