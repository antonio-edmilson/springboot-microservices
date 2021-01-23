package br.com.andrade.marketplace.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
	
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private LocalDate creationDate;
	private String category;
	private Double score;
	
	

}
