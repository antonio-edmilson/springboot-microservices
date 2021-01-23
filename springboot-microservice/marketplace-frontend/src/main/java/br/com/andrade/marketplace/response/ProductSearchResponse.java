package br.com.andrade.marketplace.response;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class ProductSearchResponse {
	
	private LocalDate correntDate;
	private List<String> searchTerms;
	private String message;
	private List<ProductResponse> products;

}
