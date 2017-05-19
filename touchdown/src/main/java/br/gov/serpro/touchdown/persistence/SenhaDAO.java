package br.gov.serpro.touchdown.persistence;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.apache.commons.lang.StringUtils;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.serpro.touchdown.domain.Senha;
import br.gov.serpro.touchdown.domain.filtro.FiltroSenha;

@PersistenceController
public class SenhaDAO extends JPACrud<Senha, Long> {

	private static final long serialVersionUID = 1L;

	public List<Senha> listarSenhas(FiltroSenha filtro) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select s from Senha s");
		jpql.append(" where 1 = 1 ");

		if (StringUtils.isNotBlank(filtro.getUsuario().getCpf())) {
			jpql.append("and s.usuario.cpf like :cpf ");
		}

		if (StringUtils.isNotBlank(filtro.getUsuario().getNome())) {
			jpql.append("and s.usuario.nome like :nome ");
		}
		
		if (filtro.isAtivo() == true) {
			jpql.append("and s.ativo = :ativo ");
		}
		
		TypedQuery<Senha> query = getEntityManager().createQuery(jpql.toString(), Senha.class);

		if (StringUtils.isNotBlank(filtro.getUsuario().getCpf())) {
			query.setParameter("cpf", filtro.getUsuario().getCpf());
		}

		if (StringUtils.isNotBlank(filtro.getUsuario().getNome())) {
			query.setParameter("nome", filtro.getUsuario().getNome() + "%");
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

}