package com.iftm.exemplelockpessimista;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import com.iftm.exemplelockpessimista.services.ContaService;

@SpringBootTest
class TestesAplicacaoLockPessimista {

	@Autowired
	private ContaService contaService;

	@Test
	void contextLoads() {
	}

	@Test
	void testContaServiceExists() {
		assertThat(contaService).isNotNull();
	}

	// Adicione mais métodos de teste aqui
}
