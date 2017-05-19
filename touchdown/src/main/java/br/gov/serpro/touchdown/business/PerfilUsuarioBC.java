package br.gov.serpro.touchdown.business;

import java.util.List;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.serpro.touchdown.domain.PerfilUsuario;
import br.gov.serpro.touchdown.domain.filtro.FiltroPerfilUsuario;
import br.gov.serpro.touchdown.persistence.PerfilUsuarioDAO;

@BusinessController
public class PerfilUsuarioBC extends DelegateCrud<PerfilUsuario, Long, PerfilUsuarioDAO> {

	private static final long serialVersionUID = 1L;

	@Transactional
	PerfilUsuario salvarPerfilUsuario(PerfilUsuario perfilUsuario) {
		if (perfilUsuario.getId() == null) {
			perfilUsuario = insert(perfilUsuario);
		} else {
			perfilUsuario = update(perfilUsuario);
		}
		return perfilUsuario;
	}

	 public List<PerfilUsuario> listarPerfisUsuarios(FiltroPerfilUsuario filtro){
		 return getDelegate().listarPerfisUsuarios(filtro);
	}
	
}
