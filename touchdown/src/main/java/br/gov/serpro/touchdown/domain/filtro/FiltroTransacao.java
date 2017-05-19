package br.gov.serpro.touchdown.domain.filtro;

import br.gov.serpro.touchdown.domain.Perfil;

public class FiltroTransacao {

	private Long id;
	private String nome;
	private String descricao;
	private Perfil perfil;
	private boolean ativo;

	public FiltroTransacao() {
		this.perfil = new Perfil();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
