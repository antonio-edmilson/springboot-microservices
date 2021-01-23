package br.com.andrade.productcategory.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.andrade.productcategory.entity.Category;
import br.com.andrade.productcategory.entity.NewsCategory;
import br.com.andrade.productcategory.repository.CategoryRepository;
import br.com.andrade.productcategory.repository.NewsCategoryRepository;
import br.com.andrade.productcategory.request.CategoryRequest;
import br.com.andrade.productcategory.response.NewsResponse;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository; 
	
	@Autowired
	private NewsCategoryRepository newsCategoryRepository;
	
	@Autowired
	private NewsApiService newsApiService; 
	
	public Category save(Category category) {
		return categoryRepository.save(category);
	}
	
	public List<Category> saveAll(List<Category> categorys) {
		List<Category> categorysResult = new ArrayList<>();
		categorys.forEach(c -> categorysResult.add(categoryRepository.save(c)));
		return categorys;
	}
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Integer getAmountNewsByCategory(String nameCategory) {
		Category category = categoryRepository.findAll(Example.of(new Category(null, nameCategory))).stream().findFirst().orElse(null);
		NewsCategory newsCategory = newsCategoryRepository.findByPublishedAtAndCategory(LocalDate.now(), category);
		return newsCategory != null && newsCategory.getTotalNews() != null ? newsCategory.getTotalNews() : 0;
	}
	
	public void getNewsForCategoryAll() {
		this.findAll().forEach(category -> {
			Map<String, String> parameters = new HashMap<>();
			parameters.put(CategoryRequest.CATEGORY, category.getName());
			NewsResponse newsResponse = newsApiService.getTopheadlinesAll(parameters);
			LocalDate publishedAt = newsResponse.getArticles().get(0).getPublishedAt();
			NewsCategory newsCategory = newsCategoryRepository.findByPublishedAtAndCategory(publishedAt, category);
			saveOrUpdateNewsCategory(category, newsResponse, publishedAt, newsCategory);
		});
	}

	private void saveOrUpdateNewsCategory(Category category, NewsResponse newsResponse, LocalDate publishedAt,
			NewsCategory newsCategory) {
		if(newsCategory == null) {
			newsCategoryRepository.save(new NewsCategory(null, newsResponse.getTotalResults(), publishedAt, category));
		}else {
			newsCategory.setTotalNews(newsResponse.getTotalResults());
			newsCategoryRepository.save(newsCategory);
		}
	}
	
	public void getCategorysAllApiNews() {
		List<String> categorys = this.findAll().stream().map(Category::getName).collect(Collectors.toList());
		newsApiService.getCategorysAll(null).stream().filter(c -> !categorys.contains(c.getCategory()))
				.forEach(category -> this.save(new Category(null, category.getCategory())));
	}
}
