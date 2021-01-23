package br.com.andrade.productnotes.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiProductUpdateScoreRequest {
	
	@NotNull(message = "Required to enter a Id value")
	private Long id;
	
	@NotNull(message = "Required to enter a Score value")
	private Double score;

}
