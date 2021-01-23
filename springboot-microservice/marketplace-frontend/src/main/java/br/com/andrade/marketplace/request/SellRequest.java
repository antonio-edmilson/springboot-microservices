package br.com.andrade.marketplace.request;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellRequest {
	
	@NotNull(message = "Required to enter a idSalesman value")
	private Long idSalesman;
	
	private String nameSalesman;
	
	@NotNull(message = "Required to enter a idCostumer value")
	private Long idCustomer;
	
	private String nameCustomer;
	
	@NotBlank(message = "Required to enter a idProduct value")
	private Long idProduct;
	
	private String nameProduct;
	
	private BigDecimal price;
	
	private List<SellesProductRequest> selles;
}
