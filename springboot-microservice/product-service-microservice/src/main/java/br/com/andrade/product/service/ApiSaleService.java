package br.com.andrade.product.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andrade.product.repository.ApiSaleRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApiSaleService {
	
	@Autowired
	private ApiSaleRepository apiSaleRepository;
	
	public Long getAmountSalesByProduct(Long idProduct) {
		try {
			return apiSaleRepository.getAmountSalesByProduct(idProduct);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			return 0l;
		}
	}

}
