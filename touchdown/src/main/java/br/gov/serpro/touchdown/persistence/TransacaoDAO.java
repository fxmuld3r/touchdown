package br.gov.serpro.touchdown.persistence;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.apache.commons.lang.StringUtils;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.serpro.touchdown.domain.Transacao;
import br.gov.serpro.touchdown.domain.filtro.FiltroTransacao;

@PersistenceController
public class TransacaoDAO extends JPACrud<Transacao, Long> {

	private static final long serialVersionUID = 1L;
	
	public List<Transacao> listarTransacoes(FiltroTransacao filtro) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select t from Transacao t");
		jpql.append(" where 1 = 1 ");

		if(StringUtils.isNotBlank(filtro.getNome())){
			jpql.append("and UPPER(t.nome) like :nome ");
		}
		if (filtro.isAtivo() == true){
			jpql.append("and t.ativo = :ativo ");
		}
		
		TypedQuery<Transacao> query = getEntityManager().createQuery(jpql.toString(), Transacao.class);

		if(StringUtils.isNotBlank(filtro.getNome())){
			query.setParameter("nome", filtro.getNome() + "%");
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