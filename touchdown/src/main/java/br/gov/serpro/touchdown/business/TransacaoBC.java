package br.gov.serpro.touchdown.business;

import java.util.List;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.serpro.touchdown.domain.Transacao;
import br.gov.serpro.touchdown.domain.filtro.FiltroTransacao;
import br.gov.serpro.touchdown.persistence.TransacaoDAO;

@BusinessController
public class TransacaoBC extends DelegateCrud<Transacao, Long, TransacaoDAO> {

	private static final long serialVersionUID = 1L;
	
	@Transactional
	Transacao salvarTransacao(Transacao transacao) {
		if(transacao.getId() == null) {
			transacao = insert(transacao);
		}
		else {
			transacao = update(transacao);
		}
		return transacao;		
	}

	public List<Transacao> listarTransacoes(FiltroTransacao filtro){
		return getDelegate().listarTransacoes(filtro);
	}
	
}