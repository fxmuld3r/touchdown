package br.gov.serpro.touchdown.view;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.serpro.touchdown.business.TransacaoBC;
import br.gov.serpro.touchdown.domain.Transacao;
import br.gov.serpro.touchdown.domain.filtro.FiltroTransacao;

@ViewController
public class TransacaoMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TransacaoBC bc;
	
	private FiltroTransacao filtro;

	public TransacaoMB() {
		this.filtro = new FiltroTransacao();
	}

	public List<Transacao> getListarTransacoes() {
		return this.bc.listarTransacoes(filtro);
	}

	public FiltroTransacao getFiltro() {
		return filtro;
	}

	public void limpar() {
		this.filtro = new FiltroTransacao();
	}

}
