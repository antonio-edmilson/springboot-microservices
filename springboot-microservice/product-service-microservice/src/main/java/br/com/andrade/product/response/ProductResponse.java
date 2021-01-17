package br.com.andrade.product.response;

import java.time.LocalDate;
import java.util.List;

import br.com.andrade.product.entity.Product;
import lombok.Data;

@Data
public class ProductResponse {
	
	private LocalDate correntDate;
	private List<String> termoPesquisado;
	private Product product;

	public ProductResponse() {
		this.correntDate = LocalDate.now();
	}

	public ProductResponse(List<String> termoPesquisado, Product product) {
		this.correntDate = LocalDate.now();
		this.termoPesquisado = termoPesquisado;
		this.product = product;
	}
}
