package br.com.andrade.productnotes.request;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.andrade.productnotes.entity.ProductNote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductNoteRequest {
	
	@Min(value = 0, message = "Score between 0 and 5")
	@Max(value = 5, message = "Score between 0 and 5")
	@NotNull(message = "Required to enter a note value")
	@Column(name="note", nullable = false)
	private Integer note;
	
	@NotNull(message = "Required to enter a idProduct value")
	@Column(name="idProduct", nullable = false)
	private Long idProduct;
	
	public final static ProductNote parseProductNote(ProductNoteRequest productNoteRequest) {
		return new ProductNote(productNoteRequest.getIdProduct(), productNoteRequest.getNote());
	}

}
