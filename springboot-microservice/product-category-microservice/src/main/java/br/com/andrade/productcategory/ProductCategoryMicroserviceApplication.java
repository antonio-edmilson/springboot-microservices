package br.com.andrade.productcategory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "br.com.andrade")
public class ProductCategoryMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCategoryMicroserviceApplication.class, args);
	}

}
