package com.demo.invoicescanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class InvoiceScannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceScannerApplication.class, args);
	}

}
