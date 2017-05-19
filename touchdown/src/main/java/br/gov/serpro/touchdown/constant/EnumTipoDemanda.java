package br.gov.serpro.touchdown.constant;

public enum EnumTipoDemanda {

	//DESENVOLVIMENTO(1, "Projeto de Desenvolvimento"), MANUTENCAO(2, "Projeto de Manutenção"), MUDANCAESCOPO(3, "Mudança de Escopo"), ENTREGA(4, "Entrega"), DEMANDA(5, "Demanda"), APLICACAO(4, "Aplicação (Baseline)");
	CORRETIVA(1, "Manutenção Corretiva"), EVOLUTIVA(2, "Manutenção Evolutiva"), ADAPTATIVA(3, "Manutenção Adaptativa"), PREVENTIVA(4, "Manutenção Preventiva"), NOVOSISTEMA(5, "Novo Sistema"), APES(6, "Apuração Especial"), DOCUMENTACAO(7, "Ducumentação do Sistema");

	private final int id;
	private final String nome;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	private EnumTipoDemanda(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
}
