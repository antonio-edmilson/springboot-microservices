package br.com.andrade.marketplace.repository;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.andrade.marketplace.response.CategoryResponse;

@Repository
public class ApiProductCategoryRepository extends ApiUtilsRepository {
	
	private final String URI_PRODUCTAPI = "http://localhost:9094";
	private final String ENDPOINT_PRODUCTAPI = "/api/v1/product-category";
	
	public List<CategoryResponse> findByAll() {
		CategoryResponse[] categorys = getRestTemplate(URI_PRODUCTAPI + ENDPOINT_PRODUCTAPI, null, CategoryResponse[].class);
		return Arrays.asList(categorys);
	}
}
