package br.gov.serpro.touchdown.constant;

public enum EnumCicloVida {

	CASCATA(1, "Cascata"), ITERATIVO(2, "Iterativo");

	private final int id;
	private final String nome;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	private EnumCicloVida(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
}
