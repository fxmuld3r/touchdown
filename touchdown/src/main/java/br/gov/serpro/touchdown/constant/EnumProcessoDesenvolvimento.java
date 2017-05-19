package br.gov.serpro.touchdown.constant;

public enum EnumProcessoDesenvolvimento {

	COMPLETO(1, "Completo"), AGIL(2, "Ágil"), EXPRESSO(3, "Expresso"), SUMARIO(4, "Sumário");

	private final int id;
	private final String nome;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	private EnumProcessoDesenvolvimento(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

}
