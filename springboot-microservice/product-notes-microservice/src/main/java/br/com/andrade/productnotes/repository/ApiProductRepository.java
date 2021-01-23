package br.com.andrade.productnotes.repository;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.andrade.productnotes.request.ApiProductUpdateScoreRequest;

@Repository
public class ApiProductRepository {
	
	private final String URI_PRODUCTAPI = "http://localhost:9090";
	private final String ENDPOINT_PRODUCTAPI = "/api/v1/product-note";
	
	public ApiProductUpdateScoreRequest updateScoreProduct(Long idProduct) {
		String uri = URI_PRODUCTAPI + ENDPOINT_PRODUCTAPI + "/"+ idProduct;
		RestTemplate restTemplate = new RestTemplate();
	    return restTemplate.getForObject(uri,  ApiProductUpdateScoreRequest.class);
	}

}
