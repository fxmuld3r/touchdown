package br.gov.serpro.touchdown.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import br.gov.frameworkdemoiselle.exception.ApplicationException;

/**
 * Classe responsável por concentrar todas as exceções do sistema, toda exceção
 * deve ser transformada em uma {@link SistemaException} para que seja exibida uma
 * mensagem amigável ao usuário final
 * 
 * @author SERPRO
*/

@ApplicationException(rollback=true)
public class SistemaException extends RuntimeException {
	private static final long serialVersionUID = -4445672983351265827L;

	private Throwable causa;
	private List<String> mensagens = new ArrayList<String>();
	private String mensagem;

	public SistemaException(String chaveMensagem, Throwable t) {
		this.mensagem = chaveMensagem;
		this.causa = t;
	}

	public SistemaException(List<String> chavesMensagens, Throwable t) {
		this.mensagens = chavesMensagens;
		this.causa = t;
	}

	public SistemaException(String chaveMensagem) {
		this.mensagem = chaveMensagem;
	}
	
	public SistemaException(List<String> chavesMensagens) {
		this.mensagens = chavesMensagens;
	}

	@Override
	public String getMessage() {
		return this.mensagem;
	}

	@Override
	public synchronized Throwable getCause() {
		return causa;
	}

	public List<String> getMessages() {
		if (this.mensagens == null || this.mensagens.isEmpty()) {
			if (mensagem != null) {
				return new ArrayList<String>(Arrays.asList(new String[]{mensagem}));
			}
		}
		return mensagens;
	}
}
