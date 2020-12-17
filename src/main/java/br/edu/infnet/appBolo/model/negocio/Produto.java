package br.edu.infnet.appBolo.model.negocio;

public abstract class Produto {
	
	private String descricao;
	private float valor;
	private boolean adicional;
	
	public Produto(String descricao, float valor, boolean adicional) {
		this.descricao = descricao;
		this.valor = valor;
		this.adicional = adicional;		
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(this.getDescricao());
		sb.append(";");
		sb.append(this.getValor());
		sb.append(";");
		sb.append(this.isAdicional());
		
		return sb.toString();
	}
	
	public abstract float calcularValorVenda();
	
	public String obterValorProduto() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(getDescricao());
		sb.append(";");
		sb.append(this.calcularValorVenda());
	
		return sb.toString();
		
	}
			
	public String getDescricao() {
		return descricao;
	}

	public float getValor() {
		return valor;
	}

	public boolean isAdicional() {
		return adicional;
	}

}
