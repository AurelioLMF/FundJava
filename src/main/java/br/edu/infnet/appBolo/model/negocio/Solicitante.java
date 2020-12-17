package br.edu.infnet.appBolo.model.negocio;

public class Solicitante {
	
	private String nome;
	private String cpf;
	private String email;
	
	public Solicitante(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(getNome());
		sb.append(";");
		sb.append(getCpf());
		sb.append(";");
		sb.append(getEmail());
		
		return sb.toString();
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}
	

}
