package com.Ordenes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.Ordenes")
public class OrdenesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdenesApplication.class, args);

		System.out.println("Conexión a servicio de ordenes establecida");
	}

}
