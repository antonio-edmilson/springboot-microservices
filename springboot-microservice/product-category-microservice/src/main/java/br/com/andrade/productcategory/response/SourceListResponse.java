package br.com.andrade.productcategory.response;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SourceListResponse {
	private String status;
    private List<SourceResponse> sources;
    
    public SourceListResponse() {
    	sources = new ArrayList<>();
    }
}
