package br.gov.serpro.touchdown.persistence;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.apache.commons.lang.StringUtils;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.serpro.touchdown.domain.Usuario;
import br.gov.serpro.touchdown.domain.filtro.FiltroUsuario;

@PersistenceController
public class UsuarioDAO extends JPACrud<Usuario, Long> {

	private static final long serialVersionUID = 1L;

	public List<Usuario> listar(FiltroUsuario filtro) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select u from Usuario u");
		jpql.append(" where 1 = 1 ");

		if (filtro.getId() != null) {
			jpql.append("and u.id = :id ");
		}
		if (StringUtils.isNotBlank(filtro.getCpf())) {
			jpql.append("and UPPER(u.cpf) like :cpf ");
		}
		if (StringUtils.isNotBlank(filtro.getNome())) {
			jpql.append("and UPPER(u.nome) like :nome ");
		}
		if (filtro.isAtivo() == true) {
			jpql.append("and u.ativo = :ativo ");
		}

		TypedQuery<Usuario> query = getEntityManager().createQuery(jpql.toString(), Usuario.class);

		if (filtro.getId() != null) {
			query.setParameter("id", filtro.getId());
		}
		if (StringUtils.isNotBlank(filtro.getCpf())) {
			query.setParameter("cpf", filtro.getCpf());
		}
		if (StringUtils.isNotBlank(filtro.getNome())) {
			query.setParameter("nome", filtro.getNome() + "%");
		}
		if (filtro.isAtivo() == true) {
			query.setParameter("ativo", filtro.isAtivo());
		}

		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	
	public Usuario buscarUsuario(FiltroUsuario filtro) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select u from Usuario u");
		jpql.append(" where 1 = 1 ");

		if (filtro.getId() != null) {
			jpql.append("and u.id = :id ");
		}
		if (StringUtils.isNotBlank(filtro.getCpf())) {
			jpql.append("and UPPER(u.cpf) like :cpf ");
		}

		TypedQuery<Usuario> query = getEntityManager().createQuery(jpql.toString(), Usuario.class);

		if (filtro.getId() != null) {
			query.setParameter("id", filtro.getId());
		}
		if (StringUtils.isNotBlank(filtro.getCpf())) {
			query.setParameter("cpf", filtro.getCpf());
		}

		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
}