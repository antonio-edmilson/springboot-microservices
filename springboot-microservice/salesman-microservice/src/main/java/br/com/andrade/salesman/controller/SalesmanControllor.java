package br.com.andrade.salesman.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrade.salesman.entity.Salesman;
import br.com.andrade.salesman.request.SalesmanRequest;
import br.com.andrade.salesman.response.SalesmanResponse;
import br.com.andrade.salesman.service.SalesmanService;

@RestController
@RequestMapping(value = "/api/v1/salesman")
public class SalesmanControllor {
	
	@Autowired
	private SalesmanService salesmanService;
	
	@PostMapping
	public ResponseEntity<SalesmanResponse> create(@Valid @RequestBody SalesmanRequest salesmanRequest) {
		Salesman salesman = salesmanService.save(SalesmanRequest.parserCustomer(salesmanRequest));
		return ResponseEntity.ok(new SalesmanResponse(salesman, " Salesman successfully created"));
	}

}
