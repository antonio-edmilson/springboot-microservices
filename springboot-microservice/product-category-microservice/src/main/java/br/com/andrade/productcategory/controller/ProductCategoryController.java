package br.com.andrade.productcategory.controller;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrade.productcategory.entity.Category;
import br.com.andrade.productcategory.response.SourceResponse;
import br.com.andrade.productcategory.service.CategoryService;
import br.com.andrade.productcategory.service.NewsApiService;

@RestController
@RequestMapping(value = "/api/v1/product-caretory")
public class ProductCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		return ResponseEntity.ok(categoryService.findAll());
	}
	
	@GetMapping("/amount-news/{category}")
	public ResponseEntity<Integer> getAmountNewsByCategory(@PathVariable(value = "category") String category){
		return ResponseEntity.ok(categoryService.getAmountNewsByCategory(category));
	}
	
	
	

}
