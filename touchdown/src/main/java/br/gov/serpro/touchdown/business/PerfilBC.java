package br.gov.serpro.touchdown.business;

import java.util.List;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.serpro.touchdown.domain.Perfil;
import br.gov.serpro.touchdown.domain.filtro.FiltroPerfil;
import br.gov.serpro.touchdown.persistence.PerfilDAO;

@BusinessController
public class PerfilBC extends DelegateCrud<Perfil, Long, PerfilDAO> {

	private static final long serialVersionUID = 1L;

	@Transactional
	Perfil salvarPerfil(Perfil perfil) {
		if (perfil.getId() == null) {
			perfil = insert(perfil);
		} else {
			perfil = update(perfil);
		}
		return perfil;
	}

	public List<Perfil> listarPerfis(FiltroPerfil filtro) {
		return getDelegate().listarPerfis(filtro);
	}

}
