package br.gov.serpro.touchdown.domain.filtro;

import br.gov.serpro.touchdown.domain.Perfil;
import br.gov.serpro.touchdown.domain.Usuario;

public class FiltroPerfilUsuario {

	private Long id;
	private Usuario usuario;
	private Perfil perfil;
	private boolean ativo;

	public FiltroPerfilUsuario(){
		usuario = new Usuario();
		perfil = new Perfil();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
