package br.com.andrade.salesman.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/salesman")
public class SalesmanControllor {
	
	public String save() {
		return "teste";
	}

}
