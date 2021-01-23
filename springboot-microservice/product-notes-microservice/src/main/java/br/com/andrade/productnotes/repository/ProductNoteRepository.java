package br.com.andrade.productnotes.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.andrade.productnotes.entity.ProductNote;
import br.com.andrade.productnotes.response.NoteAverageResponse;

@Repository
public interface ProductNoteRepository extends JpaRepository<ProductNote, Long> {
	
	@Query("SELECT new br.com.andrade.productnotes.response.NoteAverageResponse(avg(pn.note), pn.idProduct) FROM br.com.andrade.productnotes.entity.ProductNote pn WHERE pn.idProduct = :idProduct AND pn.creationDate between :dataInit and :dataFinal")
	public NoteAverageResponse getProductEvaluationLastTwelveMonths(@Param("idProduct") Long idProduct, @Param("dataInit") LocalDate dataInit, @Param("dataFinal") LocalDate dataFinal);

}
