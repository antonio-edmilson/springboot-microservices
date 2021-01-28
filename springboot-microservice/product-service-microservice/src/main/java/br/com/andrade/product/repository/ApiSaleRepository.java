package br.com.andrade.product.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import br.com.andrade.product.response.NoteAverageResponse;

@Repository
public class ApiSaleRepository {
	
	private final String URI_PRODUCTAPI = "http://localhost:8080";
	private final String ENDPOINT_PRODUCTAPI = "/sale/api/v1/sale";
	
	public Long getAmountSalesByProduct(Long idProduct) {
		String uri = URI_PRODUCTAPI + ENDPOINT_PRODUCTAPI + "/"+ idProduct;
		RestTemplate restTemplate = new RestTemplate();
	    return restTemplate.getForObject(uri,  Long.class);
	}

}
