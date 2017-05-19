package br.gov.serpro.touchdown.view;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.serpro.touchdown.business.PerfilBC;
import br.gov.serpro.touchdown.domain.Perfil;
import br.gov.serpro.touchdown.domain.filtro.FiltroPerfil;

@ViewController
public class PerfilMB implements Serializable {
	// public class PerfilMB extends AbstractListPageBean<Perfil, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private PerfilBC bc;
	
	private FiltroPerfil filtro;

	public PerfilMB() {
		this.filtro = new FiltroPerfil();
	}

	public List<Perfil> getListarPerfis() {
		return this.bc.listarPerfis(filtro);
	}

	public FiltroPerfil getFiltro() {
		return filtro;
	}

	public void limpar() {
		this.filtro = new FiltroPerfil();
	}

}