package br.com.andrade.productcategory.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.andrade.productcategory.entity.Category;
import br.com.andrade.productcategory.entity.NewsCategory;

@Repository
public interface NewsCategoryRepository extends JpaRepository<NewsCategory, Long> {

	NewsCategory findByPublishedAtAndCategory(LocalDate publishedAt, Category category);
}
