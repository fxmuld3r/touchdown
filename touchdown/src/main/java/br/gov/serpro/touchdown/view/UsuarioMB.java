package br.gov.serpro.touchdown.view;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import br.gov.frameworkdemoiselle.annotation.Name;
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
public class UsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	private ResourceBundle bundle;

	@Inject
	private Logger logger;

	@Inject
    @SessionScoped
    @Name("parametro")
	private Parameter<Long> parametro;

	@Inject
	private Instance<UsuarioBC> usuarioBC;
	private Usuario usuario = new Usuario();
	private List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private FiltroUsuario filtro = new FiltroUsuario();;
	
	public UsuarioMB() {
		FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
        String param = req.getParameter("parametro");
        System.out.println("rrrrrrrrrrrrrrrrrrr" + param + "rrrrrrrrrrrrrrrrrrrrrrrrrr");

        if (param != null) {
        	preparaEdicao();
        }
        
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public FiltroUsuario getFiltro() {
		return filtro;
	}

	public List<Usuario> getListaUsuarios() {
		listaUsuarios = listar();
		return listaUsuarios;
	}

	public void limpar() {
		this.filtro = new FiltroUsuario();
		this.usuario = new Usuario();
		this.listaUsuarios = new ArrayList<Usuario>();
		this.parametro.setValue(null);
	}

	public void preparaEdicao() {
		System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
	}
	
	
	// public String voltar() {
	// return "consultarusuarios?faces-redirect=true";
	// }

	public List<Usuario> listar() {
		try {
			
			
			
			
			// verifica se há parametro enviado
			if (this.parametro.getValue() != null) {
				System.out.println("zzzz entra quando parametro é diferente de nulo:" + this.parametro.getValue() + "zzz");
				//this.filtro.setId(parametro.getValue());
			} else {
				System.out.println("xxx entra quando parametro é  nulo:" + this.parametro.getValue() + "xxx");
			}
			
			
			
			// lista se há filtro(s) selecionado
			// if (this.filtro.getId() != null || this.filtro.getCpf() != null
			// || this.filtro.getNome() != null) {
			// if (this.filtro.getNome().toString().isEmpty() == false ||
			// this.filtro.getCpf().toString().isEmpty() == false) {

			// retira espaços em branco para a consulta
			if (this.filtro.getNome() != null) {
				this.filtro.setNome(filtro.getNome().trim());
			}

			return this.usuarioBC.get().listar(filtro);
			// } else {
			// return null;
			// }
			// } else {
			// return null;
			// //return new ArrayList<Usuario>();
			// }
		} catch (Exception e) {
			logger.error("usuario.erro.consultar", e);
			throw new SistemaException("usuario.erro.consultar", e);
		}
	}

	public void excluir(Usuario usuario) {
		try {
			usuarioBC.get().excluir(usuario);
		} catch (Exception e) {
			logger.error("usuario.erro.excluir", e);
			throw new SistemaException("usuario.erro.excluir", e);
		}
	}

	public String salvar() {
		try {
			usuario.setNome(usuario.getNome().toUpperCase());
			usuarioBC.get().salvar(usuario);
			this.novo();
			return "consultarusuarios?faces-redirect=true";
		} catch (Exception e) {
			logger.error("usuario.erro.salvar", e);
			throw new SistemaException("usuario.erro.salvar", e);
		}
	}

	public void novo() {
		try {
			this.usuario = new Usuario();
			this.listaUsuarios = new ArrayList<Usuario>();
			this.filtro = new FiltroUsuario();
		} catch (Exception e) {
			logger.error("usuario.erro.adicionar", e);
			throw new SistemaException("usuario.erro.adicionar", e);
		}
	}

	@ExceptionHandler
	private void tratarSQLException(SQLException e) {
		if (e instanceof com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException) {
			throw new SistemaException("usuario.erro.registrosassociados", e);
		} else {
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