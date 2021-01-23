package br.com.andrade.productcategory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableEurekaClient
@EnableScheduling
@SpringBootApplication(scanBasePackages = "br.com.andrade")
public class ProductCategoryMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCategoryMicroserviceApplication.class, args);
	}

}
