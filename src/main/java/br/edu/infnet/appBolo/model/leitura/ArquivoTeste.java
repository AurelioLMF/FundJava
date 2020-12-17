package br.edu.infnet.appBolo.model.leitura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.edu.infnet.appBolo.model.exceptions.FatiaInvalidaException;
import br.edu.infnet.appBolo.model.exceptions.IncrementoInvalidoException;
import br.edu.infnet.appBolo.model.exceptions.MedidaNegativaException;
import br.edu.infnet.appBolo.model.negocio.Cobertura;
import br.edu.infnet.appBolo.model.negocio.Massa;
import br.edu.infnet.appBolo.model.negocio.Recheio;

public class ArquivoTeste {

	public static void main(String[] args) {
		String dir = "C:/Users/aurel/OneDrive/Ambiente de Trabalho/INFNET/Fundamentos do Desenvolvimento Java (Elberth Moraes)/dev/Workspace";
		
		String arquivo = "pedido.txt";
		
		try {
			FileReader leitura = new FileReader(dir+arquivo);
			BufferedReader in = new BufferedReader(leitura);
			
			FileWriter escrita = new FileWriter(dir+"out_"+arquivo);
			BufferedWriter out = new BufferedWriter(escrita);
			
			String linha = in.readLine();
			
			while(linha != null) {
				String[] campos = linha.split(";");
				
				if(campos.length == 5) {
					
				} else {
					switch(campos[0].toUpperCase()) {
					case "M":
						Massa m = new Massa(campos[1], Float.valueOf(campos[2]), Boolean.valueOf(campos[3]));
						m.setMedida(Float.valueOf(campos[4]));
						m.setMarca(campos[5]);
						out.write(m.obterValorProduto());
						
						break;
						
					case "C":
						Cobertura cobertura = new Cobertura(campos[1], Float.valueOf(campos[2]), Boolean.valueOf(campos[3]));
						cobertura.setQuente(Boolean.valueOf(campos[4]));
						cobertura.setIncremento(Float.valueOf(campos[5]));
						out.write(cobertura.obterValorProduto());
						break;
						
					case "R":
						Recheio recheio = new Recheio(campos[1], Float.valueOf(campos[2]), Boolean.valueOf(campos[3]));
						recheio.setEmbalagem(Boolean.valueOf(campos[4]));
						recheio.setFatia(Integer.valueOf(campos[5]));
						out.write(recheio.obterValorProduto());
						break;
						
					default:
						break;
					}
				}
				
				linha = in.readLine();
			}
			
			in.close();
			leitura.close();
			out.close();
			escrita.close();
			
			System.out.println("Migração realizada com sucesso!");
			
		} catch (IOException | MedidaNegativaException | IncrementoInvalidoException | FatiaInvalidaException e) {
			System.out.println(e.getMessage());
		}
	}
}
