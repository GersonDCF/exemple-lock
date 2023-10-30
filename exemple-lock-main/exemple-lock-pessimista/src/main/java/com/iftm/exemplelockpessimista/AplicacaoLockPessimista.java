package com.iftm.exemplelockpessimista;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacaoLockPessimista {

	public static void main(String[] args) {
		System.out.println("Iniciando a aplicação...");
		SpringApplication.run(AplicacaoLockPessimista.class, args);
		System.out.println("Aplicação iniciada com sucesso!");
	}

}
