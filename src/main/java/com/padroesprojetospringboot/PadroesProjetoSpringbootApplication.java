package com.padroesprojetospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring Boot gerado pelo Spring Initializer.
 * As seguintes dependencias foram selecionadas:
 * - Spring Data JPA
 * - Spring Web
 * - H2 Database
 * - OpenFeign
 *
 * @author agryo
 */
@EnableFeignClients
@SpringBootApplication
public class PadroesProjetoSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadroesProjetoSpringbootApplication.class, args);
	}

}
