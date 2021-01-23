package br.com.andrade.product.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import br.com.andrade.product.response.NoteAverageResponse;

@Repository
public class ApiProductCategoryRepository {
	
	private final String URI_PRODUCTAPI = "http://localhost:9094";
	private final String ENDPOINT_PRODUCTAPI = "/api/v1/product-caretory/amount-news/";
	
	public Integer getAmountNewsByCategory(String category) {
		String uri = URI_PRODUCTAPI + ENDPOINT_PRODUCTAPI + "/"+ category;
		RestTemplate restTemplate = new RestTemplate();
	    return restTemplate.getForObject(uri,  Integer.class);
	}

}
