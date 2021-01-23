package br.com.andrade.productcategory.response;

import java.util.List;

import br.com.andrade.productcategory.entity.NewsCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsResponse {
	private String status;
	private String category;
    private Integer totalResults;
    private List<ArticleResponse> articles;
    

}
