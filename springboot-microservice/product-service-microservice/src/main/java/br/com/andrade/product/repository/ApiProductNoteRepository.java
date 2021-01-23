package br.com.andrade.product.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import br.com.andrade.product.response.NoteAverageResponse;

@Repository
public class ApiProductNoteRepository {
	
	private final String URI_PRODUCTAPI = "http://localhost:9095";
	private final String ENDPOINT_PRODUCTAPI = "/api/v1/product-note";
	
	public NoteAverageResponse getAverageNoteProduct(Long idProduct) {
		String uri = URI_PRODUCTAPI + ENDPOINT_PRODUCTAPI + "/"+ idProduct;
		RestTemplate restTemplate = new RestTemplate();
	    return restTemplate.getForObject(uri,  NoteAverageResponse.class);
	}

}
