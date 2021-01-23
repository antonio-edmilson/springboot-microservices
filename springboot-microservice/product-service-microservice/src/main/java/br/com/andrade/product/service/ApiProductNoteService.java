package br.com.andrade.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andrade.product.repository.ApiProductNoteRepository;
import br.com.andrade.product.response.NoteAverageResponse;

@Service
public class ApiProductNoteService {
	
	@Autowired
	private ApiProductNoteRepository apiProductNoteRepository;
	
	public Double getAverageNoteProduct(Long idProduct) {
		NoteAverageResponse noteAverageResponse = apiProductNoteRepository.getAverageNoteProduct(idProduct);
		return noteAverageResponse != null && noteAverageResponse.getAverage() != null ? noteAverageResponse.getAverage() : 0.0; 
	}

}
