package com.iftm.exemplelockotimista;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import com.iftm.exemplelockotimista.services.ContaService;

@SpringBootTest
class TestesAplicacaoLockOtimista {

	@Autowired
	private ContaService contaService;

	@Test
	void contextLoads() {
	}

	@Test
	void testContaServiceExists() {
		assertThat(contaService).isNotNull();
	}


}
