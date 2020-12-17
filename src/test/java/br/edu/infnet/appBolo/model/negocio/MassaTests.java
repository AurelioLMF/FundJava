package br.edu.infnet.appBolo.model.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.appBolo.model.exceptions.MedidaNegativaException;

@SpringBootTest
public class MassaTests{

	@Test
	void testaToString() {
		
		Massa m = new Massa("branca", 5, Boolean.TRUE);
		try {
			m.setMedida(200);
			m.setMarca("Bolo di Casa");
			assertTrue("branca;5.0;true;200.0;Bolo di Casa".equals(m.toString()));
			
		} catch (MedidaNegativaException e) {
			assertEquals("Medida Inválida", e.getMessage());
		}
		
	}
	
	@Test
	void testaCalculoValorMassa() {
		Massa m = new Massa("branca", 5, Boolean.TRUE);
		try {
			m.setMedida(200);
			m.setMarca("Bolo di Casa");
			assertEquals(m.calcularValorVenda(), 11);
			
		} catch (MedidaNegativaException e) {
			assertEquals("Medida Inválida", e.getMessage());
			
		}
	}
	
	@Test
	void testaMedidaNegativa() {
		Massa m = new Massa("branca", 5, Boolean.TRUE);
		try {
			m.setMedida(-100);
			fail("Erro na medida");
		} catch (MedidaNegativaException e) {
			assertEquals("Medida Inválida", e.getMessage());
		}
	}
}
