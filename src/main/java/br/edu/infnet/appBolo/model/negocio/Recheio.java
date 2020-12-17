package br.edu.infnet.appBolo.model.negocio;

import br.edu.infnet.appBolo.model.exceptions.FatiaInvalidaException;

public class Recheio extends Produto{

	private boolean embalagem; 
	private int fatia;
	
	public Recheio(String descricao, float valor, boolean adicional) {
		super(descricao, valor, adicional);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.isEmbalagem());
		sb.append(";");
		sb.append(this.getFatia());
		
		return sb.toString();
	}
	
	@Override
	public float calcularValorVenda() {
		float valor = this.getValor() + (this.isAdicional()? 2:0);
		float valorEmbalagem = valor * 0.1f;
		float valorFatia = (valor * 0.3f) * this.getFatia();
		
		return valor + valorEmbalagem + valorFatia ;
	}

	public boolean isEmbalagem() {
		return embalagem;
	}

	public void setEmbalagem(boolean embalagem) {
		this.embalagem = embalagem;
	}

	public int getFatia() {
		return fatia;
	}

	public void setFatia(int fatia) throws FatiaInvalidaException {
		
		if(fatia < 1 && fatia > 10) {
			throw new FatiaInvalidaException("Fatia inválida");
		}
		
		this.fatia = fatia;
	}

}
