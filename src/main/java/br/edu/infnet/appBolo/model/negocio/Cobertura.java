package br.edu.infnet.appBolo.model.negocio;

import br.edu.infnet.appBolo.model.exceptions.IncrementoInvalidoException;

public class Cobertura extends Produto{

	private boolean quente;
	private float incremento;
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.isQuente());
		sb.append(";");
		sb.append(this.getIncremento());
		
		return sb.toString();
	}
	
	@Override
	public float calcularValorVenda() {
		float valor = this.getValor() + (this.isAdicional()? 2:0);
		float valorQuente = valor * 0.5f;
		float valorIncremento = valor * 0.05f;
		
		return valor + valorQuente + valorIncremento;
	}
		
	public boolean isQuente() {
		return quente;
	}
	public void setQuente(boolean quente) {
		this.quente = quente;
	}
	public float getIncremento() {
		return incremento;
	}
	public void setIncremento(float incremento) throws IncrementoInvalidoException{
		if(incremento < 1 && incremento > 300) {
			throw new IncrementoInvalidoException("Incremento Inválido");
		}
		this.incremento = incremento;
	}
	public Cobertura(String descricao, float valor, boolean adicional) {
		super(descricao, valor, adicional);
	
	}
	
}
