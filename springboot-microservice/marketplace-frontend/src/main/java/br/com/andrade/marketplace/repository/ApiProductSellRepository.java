package br.com.andrade.marketplace.repository;


import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import br.com.andrade.marketplace.request.SellRequest;
import br.com.andrade.marketplace.response.ProductSearchResponse;

@Repository
public class ApiProductSellRepository extends ApiUtilsRepository {
	
	private final String URI_PRODUCTAPI = "http://localhost:8080";
	private final String ENDPOINT_PRODUCTAPI = "/sale/api/v1/sale";
	
	public SellRequest sellProduct(SellRequest sellRequest) { 
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForEntity(URI_PRODUCTAPI + ENDPOINT_PRODUCTAPI, sellRequest, SellRequest.class).getBody();
	}
}
