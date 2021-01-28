package br.com.andrade.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andrade.product.repository.ApiProductCategoryRepository;

@Service
public class ApiProductCategoryService {
	
	@Autowired
	private ApiProductCategoryRepository apiProductCategoryRepository;
	
	public Integer getAmountNewsByCategory(String category) {
		Integer amountNewsByCategory = (Integer) apiProductCategoryRepository.getAmountNewsByCategory(category);
		return amountNewsByCategory != null ? amountNewsByCategory : 0;
	}

}
