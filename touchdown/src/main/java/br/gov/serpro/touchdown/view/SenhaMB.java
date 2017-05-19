package br.gov.serpro.touchdown.view;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.serpro.touchdown.business.SenhaBC;
import br.gov.serpro.touchdown.domain.Senha;
import br.gov.serpro.touchdown.domain.filtro.FiltroSenha;

@ViewController
public class SenhaMB implements Serializable {
	// public class SenhaMB extends AbstractListPageBean<Senha, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SenhaBC bc;
	
	private FiltroSenha filtro;

	public SenhaMB() {
		this.filtro = new FiltroSenha();
	}

	public List<Senha> getListarSenhas() {
		return this.bc.listarSenhas(filtro);
	}

	public FiltroSenha getFiltro() {
		return filtro;
	}

	public void limpar() {
		this.filtro = new FiltroSenha();
	}
	
}