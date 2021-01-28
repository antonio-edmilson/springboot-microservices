package br.com.andrade.product.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="tb_product")
@Data
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product")
	private Long id;
	
	@NotBlank(message = "Name is mandatory")
	@Column(name = "name", nullable = false)
	private String name;
	
	@NotBlank(message = "Description is mandatory")
	@Column(name = "description", nullable = false)
	private String description;
	
	@NotNull(message = "Price is mandatory")
	private BigDecimal price;
	
	@Column(name = "creationDate", nullable = false)
	private LocalDate creationDate;
	
	@NotBlank(message = "Category is mandatory")
	@Column(name = "category", nullable = false)
	private String category;
	
	@Column(name = "score")
	private Double score;
	
	public Product (String name, String description, String category, BigDecimal price) {
		this.creationDate = LocalDate.now();
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
	}
	
	public Product (String name, String category, Double score) {
		this.creationDate = LocalDate.now();
		this.name = name;
		this.score = score;
		this.category = category;
	}
	

}
