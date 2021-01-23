package br.com.andrade.productcategory.service;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.andrade.productcategory.entity.Category;
import br.com.andrade.productcategory.entity.NewsCategory;
import br.com.andrade.productcategory.repository.NewsCategoryRepository;
import br.com.andrade.productcategory.response.NewsResponse;
import br.com.andrade.productcategory.response.SourceListResponse;
import br.com.andrade.productcategory.response.SourceResponse;

@Service
public class NewsApiService {

	private final String URL_NEWSAPI = "https://newsapi.org/v2/";
	private final String API_KEY = "apiKey=";
	private final String API_KEY_VALUE= "1b38d9cae7a44a8eab818f88c104ae5b";
	
	public List<SourceResponse> getCategorysAll(Map<String, String> parameters) {
		SourceListResponse result = getRestTemplate("sources", API_KEY_VALUE, parameters, SourceListResponse.class);
		return result.getSources().stream().collect(Collectors.groupingBy(SourceResponse::getCategory)).keySet()
				.stream().map(c -> new SourceResponse(c)).collect(Collectors.toList());
	}
	
	public NewsResponse getTopheadlinesAll(Map<String, String> parameters) {
		return getRestTemplate("top-headlines", API_KEY_VALUE, parameters, NewsResponse.class);
	}
	

	private <T> T getRestTemplate(String endpointMethod, String apiKey, Map<String, String> parameters,
			Class<T> clazz) {
		RestTemplate restTemplate = new RestTemplate();
		String url = URL_NEWSAPI + endpointMethod + "?" + API_KEY + apiKey;
		String parameter = converterMapParameter(parameters);
		return (T) restTemplate.getForObject(url + parameter, clazz);
	}

	private String converterMapParameter(Map<String, String> parameters) {
		if (parameters == null) {
			return "";
		}
		StringJoiner sjParameter = new StringJoiner("&", "&", "");
		parameters.forEach((k, v) -> sjParameter.add(k + "=" + v));
		return sjParameter.toString();
	}

}
