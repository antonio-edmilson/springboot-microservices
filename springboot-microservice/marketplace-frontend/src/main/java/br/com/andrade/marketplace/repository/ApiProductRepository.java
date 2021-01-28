package br.com.andrade.marketplace.repository;


import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import br.com.andrade.marketplace.request.ProductRequest;
import br.com.andrade.marketplace.response.ProductResponse;
import br.com.andrade.marketplace.response.ProductSearchResponse;

@Repository
public class ApiProductRepository extends ApiUtilsRepository {
	
	private final String URI_PRODUCTAPI = "http://localhost:8080";
	private final String ENDPOINT_PRODUCTAPI = "/product/api/v1/product";
	
	public ProductResponse findBy(Long id) {
		String parameter = "/findBy?idproduct="+id;
		return getRestTemplate(URI_PRODUCTAPI + ENDPOINT_PRODUCTAPI + parameter, null,ProductResponse.class);
	}
	
	public ProductSearchResponse findByExampleOrderScoreNameCategory(Map<String, String> parameters) {
		return getRestTemplate(URI_PRODUCTAPI + ENDPOINT_PRODUCTAPI, parameters, ProductSearchResponse.class);
	}
	
	public ProductSearchResponse save(ProductRequest productRequest) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForEntity(URI_PRODUCTAPI + ENDPOINT_PRODUCTAPI, productRequest, ProductSearchResponse.class).getBody();
	}
	
	public ProductSearchResponse update(ProductRequest productRequest) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<ProductRequest> requestEntity = new HttpEntity<ProductRequest>(productRequest, headers);
		return restTemplate.exchange(URI_PRODUCTAPI + ENDPOINT_PRODUCTAPI, HttpMethod.PUT, requestEntity,
				ProductSearchResponse.class).getBody();

	}
	
	public void delete(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(URI_PRODUCTAPI + ENDPOINT_PRODUCTAPI + "/"+id);
	}
	
	

}
