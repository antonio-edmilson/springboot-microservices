package br.com.andrade.sale.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tb_sales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="id_salesman", nullable = true)
	private Long idSalesman;
	
	@Column(name="id_costomer", nullable = true)
	private Long idCustomer;
	
	@Transient
	private List<Selles> selles;
	
	public Sale(Long idSalesman, Long idCustomer, List<Selles> selles) {
		this.idSalesman = idSalesman;
		this.idCustomer = idCustomer;
		this.selles = selles;
	}

}
