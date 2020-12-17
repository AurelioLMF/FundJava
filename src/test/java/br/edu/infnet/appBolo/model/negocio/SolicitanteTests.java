package br.edu.infnet.appBolo.model.negocio;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SolicitanteTests {

	@Test
	void testaInstancia(){
		
		Solicitante s = new Solicitante("aurelio","12345678901","aureliolmf@hotmail.com");
		
		assertNotNull(s);
	}
	
	@Test
	void testaToString() {
		
		Solicitante s = new Solicitante("aurelio","12345678901","aureliolmf@hotmail.com");
		
		assertTrue("aurelio;12345678901;aureliolmf@hotmail.com".equals(s.toString()));
		
	}
}
