package br.com.andrade.productcategory.request;

import lombok.Data;

@Data
public class CategoryRequest {
	public final static String CATEGORY = "category";
	private String category;
}
