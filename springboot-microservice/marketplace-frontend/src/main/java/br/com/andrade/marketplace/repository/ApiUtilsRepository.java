package br.com.andrade.marketplace.repository;


import java.util.Map;
import java.util.StringJoiner;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import br.com.andrade.marketplace.response.ProductResponse;

public abstract class ApiUtilsRepository  {
	
	protected <T> T getRestTemplate(String uri, Map<String, String> parameters,
			Class<T> clazz) {
		RestTemplate restTemplate = new RestTemplate();
		String parameter = converterMapParameter(parameters);
		return (T) restTemplate.getForObject(uri + parameter, clazz);
	}

	protected String converterMapParameter(Map<String, String> parameters) {
		if (parameters == null || parameters.isEmpty()) {
			return "";
		}
		StringJoiner sjParameter = new StringJoiner("&", "&", "");
		parameters.forEach((k, v) -> {
			if (v != null) {
				sjParameter.add(k + "=" + v);
			}
		});
		
		
		return "?" + sjParameter.toString();
	}

}
