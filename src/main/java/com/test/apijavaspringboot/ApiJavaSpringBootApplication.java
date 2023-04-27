package com.test.apijavaspringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiJavaSpringBootApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger("ApiJavaSpringBootApplication");

	public static void main(String[] args) {
		LOGGER.info("Inicializando a aplicação");
		SpringApplication.run(ApiJavaSpringBootApplication.class, args);
		LOGGER.info("Iniciado com sucesso");
	}

}
