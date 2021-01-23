package br.com.andrade.sale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrade.sale.entity.Sale;
import br.com.andrade.sale.exception.CustomExceptionHandler;
import br.com.andrade.sale.request.SaleRequest;
import br.com.andrade.sale.response.SaleResponse;
import br.com.andrade.sale.service.SaleService;

@RestController
@RequestMapping(value = "/api/v1/sale")
public class SaleControllor extends CustomExceptionHandler{
	
	@Autowired
	private SaleService saleService;
	
	@PostMapping
	public ResponseEntity<SaleResponse> registrerSale(@RequestBody SaleRequest saleRequest){
		Sale sale = saleService.save(SaleRequest.parserSale(saleRequest));
		return ResponseEntity.ok(new SaleResponse(sale," Purchase successful."));
	}
	
	@GetMapping("/{idProduct}")
	public ResponseEntity<Long> getAmountSalesByProduct(@PathVariable(value = "idProduct") Long idProduct){
		return ResponseEntity.ok(saleService.getAmountSalesByProduct(idProduct));
	}
	
}
