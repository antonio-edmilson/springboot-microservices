package br.com.andrade.marketplace.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.andrade.marketplace.response.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

	private Long id;

	@NotBlank(message = "Required to enter a name value")
	private String name;

	@NotBlank(message = "Required to enter a description value")
	private String description;

	private BigDecimal price;

	private LocalDate creationDate;

	private String category;

	private Double score;

	public static ProductRequest parserProductRequest(ProductResponse productRespose) {
		return new ProductRequest(productRespose.getId(), productRespose.getName(), productRespose.getDescription(),
				productRespose.getPrice(), productRespose.getCreationDate(), productRespose.getCategory(),
				productRespose.getScore());

	}

}
