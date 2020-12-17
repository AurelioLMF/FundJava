package br.edu.infnet.appBolo.model.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.appBolo.model.exceptions.FatiaInvalidaException;

@SpringBootTest
public class RecheioTests{

	@Test
	void testaToString() {
		Recheio recheio = new Recheio ("doce de leite", 5, Boolean.FALSE);
		recheio.setEmbalagem(Boolean.TRUE);
		try {
			recheio.setFatia(3);
			assertTrue("doce de leite;5.0;false;true;3".equals(recheio.toString()));

		} catch (FatiaInvalidaException e) {
			assertEquals("Fatia inválida", e.getMessage());
		}
		
	}
	
	@Test
	void testaFatiaInvalida() {
		Recheio recheio = new Recheio ("doce de leite", 5, Boolean.FALSE);
		recheio.setEmbalagem(Boolean.TRUE);
		try {
			recheio.setFatia(30);

		} catch (FatiaInvalidaException e) {
			assertEquals("Fatia inválida", e.getMessage());
		}
	}
}
