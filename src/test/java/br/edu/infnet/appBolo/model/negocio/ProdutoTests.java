package br.edu.infnet.appBolo.model.negocio;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdutoTests {

	@Test
	void testaMassa() {
		Massa m = new Massa("branca", 5, Boolean.TRUE);
		
		assertNotNull(m);
	}

	@Test
	void testaRecheio() {
		Recheio r = new Recheio("doce de leite", 15, Boolean.FALSE);
		
		assertNotNull(r);
	}
		
	@Test
	void TestaCobertura() {
		Cobertura c = new Cobertura("chocolate", 10, Boolean.TRUE);
		
		assertNotNull(c);
	}
}
