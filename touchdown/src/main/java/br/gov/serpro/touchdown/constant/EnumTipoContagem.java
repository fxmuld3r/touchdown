package br.gov.serpro.touchdown.constant;

public enum EnumTipoContagem {

	INICIAL(1, "Contagem Inicial"), REFERENCIA(2, "Contagem de Referência"), FINAL(3, "Contagem Final");

	private final int id;
	private final String nome;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	private EnumTipoContagem(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

}