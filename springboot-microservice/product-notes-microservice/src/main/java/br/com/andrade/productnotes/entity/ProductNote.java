package br.com.andrade.productnotes.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tb_product_note")
@Data
@NoArgsConstructor
public class ProductNote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="note", nullable = false)
	private Integer note;
	
	@Column(name="idProduct", nullable = false)
	private Long idProduct;
	
	@Column(name = "creationDate", nullable = false)
	private LocalDate creationDate;
	
	public ProductNote (Long idProduct, Integer note) {
		this.creationDate = LocalDate.now();
		this.idProduct = idProduct;
		this.note = note;
	}

}
