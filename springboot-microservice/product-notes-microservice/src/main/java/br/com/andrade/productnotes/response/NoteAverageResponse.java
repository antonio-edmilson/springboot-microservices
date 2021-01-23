package br.com.andrade.productnotes.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NoteAverageResponse {
	
	private Double average;
	
	private Long idProduct;
	
	private String message;
	
	public NoteAverageResponse(Double average, Long idProduct) {
		this.average = average;
		this.idProduct = idProduct;
	}

}
