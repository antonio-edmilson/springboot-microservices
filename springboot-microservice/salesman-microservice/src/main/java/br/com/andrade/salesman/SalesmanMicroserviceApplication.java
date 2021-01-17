package br.com.andrade.salesman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SalesmanMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesmanMicroserviceApplication.class, args);
	}

}
