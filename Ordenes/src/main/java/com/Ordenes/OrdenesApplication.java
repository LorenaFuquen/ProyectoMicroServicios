package com.Ordenes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.Ordenes")
@EnableFeignClients (basePackages = "com.Ordenes.client")
public class OrdenesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdenesApplication.class, args);

		System.out.println("Conexión a servicio de ordenes establecida");
	}

}
