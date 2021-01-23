package br.com.andrade.productnotes.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andrade.productnotes.entity.ProductNote;
import br.com.andrade.productnotes.repository.ProductNoteRepository;
import br.com.andrade.productnotes.response.NoteAverageResponse;
import lombok.extern.slf4j.Slf4j;

@Service
public class ProductNoteService {

	@Autowired
	private ProductNoteRepository productRepository;

	public ProductNote save(ProductNote productNote) {
		return productRepository.save(productNote);
	}
	
	public List<ProductNote> findAll() {
		return productRepository.findAll();
	}
	
	public NoteAverageResponse getProductEvaluationLastTwelveMonths(Long idProduto) {
		LocalDate dataFinal = LocalDate.now();
		LocalDate dataInit = dataFinal.minusYears(1);
		return productRepository.getProductEvaluationLastTwelveMonths(idProduto, dataInit, dataFinal);
	}
	
	
}
