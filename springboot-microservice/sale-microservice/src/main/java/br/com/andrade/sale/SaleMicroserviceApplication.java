package br.com.andrade.sale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "br.com.andrade")
public class SaleMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaleMicroserviceApplication.class, args);
	}

}
