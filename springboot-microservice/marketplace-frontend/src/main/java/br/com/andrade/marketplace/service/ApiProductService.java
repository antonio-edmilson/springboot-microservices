package br.com.andrade.marketplace.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andrade.marketplace.repository.ApiProductCategoryRepository;
import br.com.andrade.marketplace.repository.ApiProductRepository;
import br.com.andrade.marketplace.repository.ApiProductSellRepository;
import br.com.andrade.marketplace.request.ProductRequest;
import br.com.andrade.marketplace.request.SellRequest;
import br.com.andrade.marketplace.request.SellesProductRequest;
import br.com.andrade.marketplace.response.CategoryResponse;
import br.com.andrade.marketplace.response.ProductResponse;
import br.com.andrade.marketplace.response.ProductSearchResponse;

@Service
public class ApiProductService {
	
	@Autowired
	private ApiProductRepository apiProductRepository;
	
	@Autowired
	private ApiProductCategoryRepository apiProductCategoryRepository;
	
	@Autowired
	private ApiProductSellRepository apiProductSellRepository;
	
	public void save(ProductRequest productRequest) {
		apiProductRepository.save(productRequest);
	}
	
	public void update(ProductRequest productRequest) {
		apiProductRepository.update(productRequest);
	}
	
	public void delete(Long id) {
		apiProductRepository.delete(id);
	}
	
	public ProductSearchResponse findByExampleOrderScoreNameCategory(Map<String, String> parameters) {
		return apiProductRepository.findByExampleOrderScoreNameCategory(parameters);
	}
	
	public ProductResponse findBy(Long id) {
		return apiProductRepository.findBy(id);
	}
	
	public List<CategoryResponse> findByCategorys() {
		return apiProductCategoryRepository.findByAll();
	}
	
	public void sellProduct(SellRequest sellRequest) {
		sellRequest.setSelles(Arrays.asList(new SellesProductRequest(sellRequest.getIdProduct(), sellRequest.getPrice())));
		apiProductSellRepository.sellProduct(sellRequest);
	}

}
