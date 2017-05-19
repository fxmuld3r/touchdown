package br.gov.serpro.touchdown.persistence;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.apache.commons.lang.StringUtils;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.serpro.touchdown.domain.PerfilUsuario;
import br.gov.serpro.touchdown.domain.filtro.FiltroPerfilUsuario;

@PersistenceController
public class PerfilUsuarioDAO extends JPACrud<PerfilUsuario, Long> {

	private static final long serialVersionUID = 1L;
	
	public List<PerfilUsuario> listarPerfisUsuarios(FiltroPerfilUsuario filtro) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select p from PerfilUsuario p ");
		jpql.append(" where 1 = 1 ");

		if (filtro.getId() != null){
			jpql.append("and p.id = :id ");
		}
		
		if(StringUtils.isNotBlank(filtro.getUsuario().getNome())){
			jpql.append("and UPPER(p.usuario.nome) like :nomeusuario ");
		}

		if(StringUtils.isNotBlank(filtro.getPerfil().getNome())){
			jpql.append("and UPPER(p.perfil.nome) like :nomeperfil ");
		}
		
		if (filtro.isAtivo() == true){
			jpql.append("and p.ativo = :ativo ");
		}
		
		TypedQuery<PerfilUsuario> query = getEntityManager().createQuery(jpql.toString(), PerfilUsuario.class);

		if (filtro.getId() != null){
			query.setParameter("id", filtro.getId());
		}
		
		if(StringUtils.isNotBlank(filtro.getUsuario().getNome())){
			query.setParameter("nomeusuario", filtro.getUsuario().getNome() + "%");
		}

		if(StringUtils.isNotBlank(filtro.getPerfil().getNome())){
			query.setParameter("nomeperfil", filtro.getPerfil().getNome() + "%");
		}
		
		if (filtro.isAtivo() == true){
			query.setParameter("ativo", filtro.isAtivo());
		}
		
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}