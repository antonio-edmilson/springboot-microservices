package br.com.andrade.productnotes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrade.productnotes.entity.ProductNote;
import br.com.andrade.productnotes.exception.CustomExceptionHandler;
import br.com.andrade.productnotes.request.ProductNoteRequest;
import br.com.andrade.productnotes.response.NoteAverageResponse;
import br.com.andrade.productnotes.response.ProductNoteResponse;
import br.com.andrade.productnotes.service.ProductNoteService;

@RestController
@RequestMapping(value = "/api/v1/product-note")
public class ProductNoteControllor extends CustomExceptionHandler{
	
	@Autowired
	private ProductNoteService productNoteService;
	
	@PostMapping
	public ResponseEntity<ProductNoteResponse> create(@Valid @RequestBody ProductNoteRequest productNoteRequest) {
		ProductNote productNote = productNoteService.save(ProductNoteRequest.parseProductNote(productNoteRequest));
		return ResponseEntity.ok(new ProductNoteResponse(productNote.getNote(), productNote.getIdProduct(), "Product evaluation successfully registered."));
	}
	
	@GetMapping("/{idProduct}")
	public ResponseEntity<NoteAverageResponse> getAverageValuationLastTwelveMonths(@PathVariable(value = "idProduct") Long idProduct){
		NoteAverageResponse noteAverageResponse = productNoteService.getProductEvaluationLastTwelveMonths(idProduct);
		noteAverageResponse.setMessage("Average obtained successfully.");
		return ResponseEntity.ok(noteAverageResponse);
	}
}
