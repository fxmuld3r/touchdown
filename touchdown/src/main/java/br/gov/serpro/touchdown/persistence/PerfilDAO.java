package br.gov.serpro.touchdown.persistence;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.apache.commons.lang.StringUtils;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.serpro.touchdown.domain.Perfil;
import br.gov.serpro.touchdown.domain.filtro.FiltroPerfil;

@PersistenceController
public class PerfilDAO extends JPACrud<Perfil, Long> {

	private static final long serialVersionUID = 1L;

	public List<Perfil> listarPerfis(FiltroPerfil filtro) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select p from Perfil p");
		jpql.append(" where 1 = 1 ");

		if (StringUtils.isNotBlank(filtro.getNome())) {
			jpql.append("and p.nome like :nome ");
		}
		
		if (filtro.isAtivo() == true) {
			jpql.append("and p.ativo = :ativo ");
		}
		
		TypedQuery<Perfil> query = getEntityManager().createQuery(jpql.toString(), Perfil.class);

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
	
}
