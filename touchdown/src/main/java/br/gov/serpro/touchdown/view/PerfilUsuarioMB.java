package br.gov.serpro.touchdown.view;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.serpro.touchdown.business.PerfilUsuarioBC;
import br.gov.serpro.touchdown.domain.PerfilUsuario;
import br.gov.serpro.touchdown.domain.filtro.FiltroPerfilUsuario;

@ViewController
public class PerfilUsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PerfilUsuarioBC bc;

	private FiltroPerfilUsuario filtro;

	public PerfilUsuarioMB() {
		this.filtro = new FiltroPerfilUsuario();
	}

	public List<PerfilUsuario> getListarPerfisUsuarios() {
		return this.bc.listarPerfisUsuarios(filtro);
	}

	public FiltroPerfilUsuario getFiltro() {
		return filtro;
	}

	public void limpar() {
		this.filtro = new FiltroPerfilUsuario();
	}

	public void cadastrar() {
		/**
		 * FacesContext context = FacesContext.getCurrentInstance();
		 * FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,
		 * "Cadastro efetuado.", "Cadastrado com sucesso.");
		 * context.addMessage(null, mensagem);
		 **/
	}

}
