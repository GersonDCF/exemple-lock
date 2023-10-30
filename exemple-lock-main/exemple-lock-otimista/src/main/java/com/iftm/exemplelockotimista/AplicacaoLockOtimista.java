package com.iftm.exemplelockotimista;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacaoLockOtimista {

	public static void main(String[] args) {
		System.out.println("Iniciando a aplicação...");
		SpringApplication.run(AplicacaoLockOtimista.class, args);
		System.out.println("Aplicação iniciada com sucesso!");
	}

}
