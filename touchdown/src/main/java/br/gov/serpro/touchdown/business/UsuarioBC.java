package br.gov.serpro.touchdown.business;

import java.sql.SQLException;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ResourceBundle;
import br.gov.serpro.touchdown.domain.Usuario;
import br.gov.serpro.touchdown.domain.filtro.FiltroUsuario;
import br.gov.serpro.touchdown.exception.SistemaException;
import br.gov.serpro.touchdown.persistence.UsuarioDAO;

@BusinessController
public class UsuarioBC extends DelegateCrud<Usuario, Long, UsuarioDAO> {

	private static final long serialVersionUID = 1L;

	// @Inject
	// private FacesMessage facesMessage;

	@Inject
	private MessageContext messageContext;

	@Inject
	private ResourceBundle bundle;

	@Inject
	private Logger logger;

	public List<Usuario> listar(FiltroUsuario filtro) {
		try {
			return getDelegate().listar(filtro);
		} catch (Exception e) {
			logger.error("usuario.erro.consultar", e);
			throw new SistemaException("usuario.erro.consultar", e);
		}
	}

	@Transactional
	public Usuario salvar(Usuario usuario) {

		if (usuario.getId() == null || usuario.getId() == 0) { // salvar

			try {

				// mantem a mensagem para a página posterior
				 FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
				
				String mensagem;
				FiltroUsuario filtroUsuario = new FiltroUsuario();
				filtroUsuario.setCpf(usuario.getCpf());

				// verifica se já está cadastrado
				if (getDelegate().listar(filtroUsuario).size() > 0) {
					mensagem = bundle.getString("usuario.erro.jacadastrado", usuario.getCpf(), usuario.getNome());
					messageContext.add(mensagem);
					logger.error(mensagem);
					throw new SistemaException(mensagem);
				} else {

					getDelegate().insert(usuario);
					mensagem = bundle.getString("usuario.salvar.sucesso", usuario.getNome());
					messageContext.add(mensagem);
					logger.info(mensagem);
				}

				return usuario;

			} catch (Exception e) {
				logger.error("usuario.erro.salvar", e);
				throw new SistemaException("usuario.erro.salvar", e);
			}

		} else { // editar

			try {

				getDelegate().update(usuario);
				String mensagem = bundle.getString("usuario.salvar.sucesso", usuario.getNome());
				messageContext.add(mensagem);
				logger.info(mensagem);

				return usuario;

			} catch (Exception e) {
				logger.error("usuario.erro.salvar", e);
				throw new SistemaException("usuario.erro.salvar", e);
			}

		}

	}

	@Transactional
	public Usuario excluir(Usuario usuario) {
		try {
			
			String mensagem = bundle.getString("usuario.exclusao.sucesso", usuario.getNome());
			
			delete(usuario.getId());
			
			messageContext.add(mensagem);
			logger.info(mensagem);

			
			return usuario;
		} catch (Exception e) {
			logger.error("usuario.erro.excluir", e);
			throw new SistemaException("usuario.erro.excluir", e);
		}
	}

	@ExceptionHandler
	private void tratarRollbackException(RollbackException e) {
		throw new SistemaException("usuario.erro.salvar", e);
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
	private void tratarConstraintViolationException(ConstraintViolationException e) {
		throw new SistemaException("usuario.erro.salvar", e);
	}

	@ExceptionHandler
	private void tratarPersistenceException(PersistenceException e) {
		throw new SistemaException("usuario.erro.salvar", e);
	}

	@ExceptionHandler
	public void tratarSistemaException(SistemaException e) {
		logger.error("sistema.erro", e);
		String mensagem = bundle.getString("sistema.erro");
		messageContext.add(mensagem);
	}

}