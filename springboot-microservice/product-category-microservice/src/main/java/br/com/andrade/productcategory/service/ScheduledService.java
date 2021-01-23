package br.com.andrade.productcategory.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledService {
	
	@Autowired
	private CategoryService categoryService;
	
	@Scheduled(cron = "0 0 0/6 * * *")
	public void getTopheadlinesApiNews() {
		categoryService.getNewsForCategoryAll();
	}
	
	@Scheduled(cron = "0 30 2 1 * *")
	public void getCategoryAllApiNews() {
		categoryService.getCategorysAllApiNews();
	}
	
	@PostConstruct
	public void onStartCategory() {
		categoryService.getCategorysAllApiNews();
		categoryService.getNewsForCategoryAll();
	}

}
