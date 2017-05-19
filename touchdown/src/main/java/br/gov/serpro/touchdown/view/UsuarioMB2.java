package br.gov.serpro.touchdown.view;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import org.slf4j.Logger;
import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.gov.frameworkdemoiselle.util.ResourceBundle;
import br.gov.serpro.touchdown.business.UsuarioBC;
import br.gov.serpro.touchdown.domain.Usuario;
import br.gov.serpro.touchdown.domain.filtro.FiltroUsuario;
import br.gov.serpro.touchdown.exception.SistemaException;

@ViewController
public class UsuarioMB2 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	private ResourceBundle bundle;

	@Inject
	private Logger logger;

	@Inject
	private Parameter<Long> parametro;

	@Inject
	private Instance<UsuarioBC> usuarioBC;
	private Usuario usuario = new Usuario();
	private FiltroUsuario filtro;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public FiltroUsuario getFiltro() {
		return filtro;
	}

	public UsuarioMB2() {
		this.filtro = new FiltroUsuario();
		this.usuario = new Usuario();
	}

	public void limpar() {
		this.filtro = new FiltroUsuario();
		this.usuario = new Usuario();
		this.parametro = null;
	}

	public String voltar() {
		return "consultarusuarios?faces-redirect=true";
	}

	public List<Usuario> getListarUsuarios() {

		// verifica se há parametro enviado
		if (this.parametro != null) {
			System.out.println("zzzz entra quando parametro é diferente de nulo:" + this.parametro.getValue() + "zzz");
			this.filtro.setId(parametro.getValue());
		}

		// lista se há filtro(s) selecionado
		if (this.filtro.getId() != null || this.filtro.getCpf() != null || this.filtro.getNome() != null) {
			System.out.println("xxx entra quando filtro é diferente de nulo - id:" + this.filtro.getId() + "xxx");
			System.out.println("xxx entra quando filtro é diferente de nulo - cpf:" + this.filtro.getCpf() + "xxx");
			System.out.println("xxx entra quando filtro é diferente de nulo - nome:" + this.filtro.getNome() + "xxx");
			return this.usuarioBC.get().listar(filtro);
		} else {
			return null;
		}

	}

	public String excluir(Usuario usuario) {
		try {
			usuarioBC.get().excluir(usuario).getId();
			
			return "OK exluir";
			
		} catch (Exception e) {
			logger.error("usuario.erro.excluir", e);
			throw new SistemaException("usuario.erro.excluir", e);
		}
	}

	public String salvar() {
		try {

			usuarioBC.get().salvar(usuario);
			// ----->>>>> throw new RuntimeException();

			// verifica se foi salvo
			if (usuario.getId() != null) {
				return "consultarusuarios.xhtml?parametro=" + usuario.getId() + "&faces-redirect=true";
			} else {
				return "consultarusuarios.xhtml?faces-redirect=true";
			}

		} catch (Exception e) {
			logger.error("usuario.erro.salvar", e);
			throw new SistemaException("usuario.erro.salvar", e);
		}
	}

	@ExceptionHandler
	public void tratarSistemaException(SistemaException e) {
		logger.error("sistema.erro", e);
		String mensagem = bundle.getString("sistema.erro");
		messageContext.add(mensagem);
	}

}