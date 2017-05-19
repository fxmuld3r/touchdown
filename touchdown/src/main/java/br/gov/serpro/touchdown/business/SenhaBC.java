package br.gov.serpro.touchdown.business;

import java.util.List;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.serpro.touchdown.domain.Senha;
import br.gov.serpro.touchdown.domain.filtro.FiltroSenha;
import br.gov.serpro.touchdown.persistence.SenhaDAO;

@BusinessController
public class SenhaBC extends DelegateCrud<Senha, Long, SenhaDAO> {

	private static final long serialVersionUID = 1L;
	
	@Transactional
	Senha salvarSenha(Senha senha) {
		if(senha.getId() == null) {
			senha = insert(senha);
		}
		else {
			senha = update(senha);
		}
		return senha;		
	}

	public List<Senha> listarSenhas(FiltroSenha filtro){
		return getDelegate().listarSenhas(filtro);
	}
	
}
