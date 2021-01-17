package br.com.andrade.productnotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProductNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductNotesApplication.class, args);
	}

}
