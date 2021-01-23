package br.com.andrade.salesman.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tb_salesman")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salesman {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="name", nullable = true)
	private String name;
	
	@Column(name="login", nullable = true)
	private String login;
	
	@Column(name="password", nullable = true)
	private String password;

}
