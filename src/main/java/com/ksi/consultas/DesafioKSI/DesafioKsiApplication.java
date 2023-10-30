package com.ksi.consultas.DesafioKSI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioKsiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioKsiApplication.class, args);
	}

}
