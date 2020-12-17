package br.edu.infnet.appBolo.model.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.appBolo.model.exceptions.IncrementoInvalidoException;

@SpringBootTest
public class CoberturaTests{
	
	@Test
	void testaToString() {
		Cobertura cobertura = new Cobertura("chocolate", 10, Boolean.TRUE);
		cobertura.setQuente(Boolean.FALSE);
		try {
			cobertura.setIncremento(100);
			assertTrue("chocolate;10.0;true;false;100.0".equals(cobertura.toString()));

		} catch (IncrementoInvalidoException e) {
			assertEquals("Incremento Inválido", e.getMessage());
		}
		
	}

	@Test
	void testaCalculoValorCobertura(){
		Cobertura cobertura = new Cobertura("chocolate", 10, Boolean.TRUE);
		cobertura.setQuente(Boolean.FALSE);
		assertEquals(cobertura.calcularValorVenda(), 18.6f);
		try {
			cobertura.setIncremento(100);
		} catch (IncrementoInvalidoException e) {
			assertEquals("Incremento Inválido", e.getMessage());

		}
	}
	
	void testaIncrementoInvalido() {
		
		try {
			Cobertura cobertura = new Cobertura("chocolate", 10, Boolean.TRUE);
			cobertura.setQuente(Boolean.FALSE);
			cobertura.setIncremento(500);
			fail();
		} catch (IncrementoInvalidoException e) {
			assertEquals("Incremento Inválido", e.getMessage());

		}
	}
}