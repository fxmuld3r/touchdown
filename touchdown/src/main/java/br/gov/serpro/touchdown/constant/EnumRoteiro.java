package br.gov.serpro.touchdown.constant;

public enum EnumRoteiro {

	DMM(1, "DMM"), INCRA(2, "INCRA"), MJ(3, "MJ (SISPEDEN e Comunidades Terapêuticas)"), RFB(4, "RFB"), SERPRO(5,
			"SERPRO"), SISP20(6, "SISP v2.0"), SISPV22(7, "SISP v2.2"), SPOAMF(8, "SPOA/MF"), STN(9, "STN");

	private final int id;
	private final String nome;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	private EnumRoteiro(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

}
