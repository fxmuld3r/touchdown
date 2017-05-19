package br.gov.serpro.touchdown.domain;

import java.util.Date;

import br.gov.serpro.touchdown.constant.EnumCicloVida;
import br.gov.serpro.touchdown.constant.EnumProcessoDesenvolvimento;
import br.gov.serpro.touchdown.constant.EnumRoteiro;
import br.gov.serpro.touchdown.constant.EnumTipoDemanda;

public class Projeto {

	private Long id;
	private Date dataCriacao;
	private Sistema sistema;
	private Usuario rsponsavel;
	private int tamanhoPrevisto;
	private int produtividade;
	private int tamanhoRealizado;
	private EnumRoteiro roteiro;
	private int tamanhoPrevistoPFRoteiroCliente;
	private int tamanhoRealizadoPFRoteiroCliente;
	private EnumTipoDemanda tipoDemanda;
	private EnumProcessoDesenvolvimento tipoProcesso;
	private EnumCicloVida ciloVida;
	private String ug;
	private String lotacao;
	private String ugDemandante;
	private Date dataInicioRealizada;
	private Date dataTerminoPrevista;
	private Date dataTerminoRealizada;
	private String descricao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Sistema getSistema() {
		return sistema;
	}
	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	public Usuario getRsponsavel() {
		return rsponsavel;
	}
	public void setRsponsavel(Usuario rsponsavel) {
		this.rsponsavel = rsponsavel;
	}
	public int getTamanhoPrevisto() {
		return tamanhoPrevisto;
	}
	public void setTamanhoPrevisto(int tamanhoPrevisto) {
		this.tamanhoPrevisto = tamanhoPrevisto;
	}
	public int getProdutividade() {
		return produtividade;
	}
	public void setProdutividade(int produtividade) {
		this.produtividade = produtividade;
	}
	public int getTamanhoRealizado() {
		return tamanhoRealizado;
	}
	public void setTamanhoRealizado(int tamanhoRealizado) {
		this.tamanhoRealizado = tamanhoRealizado;
	}
	public EnumRoteiro getRoteiro() {
		return roteiro;
	}
	public void setRoteiro(EnumRoteiro roteiro) {
		this.roteiro = roteiro;
	}
	public int getTamanhoPrevistoPFRoteiroCliente() {
		return tamanhoPrevistoPFRoteiroCliente;
	}
	public void setTamanhoPrevistoPFRoteiroCliente(int tamanhoPrevistoPFRoteiroCliente) {
		this.tamanhoPrevistoPFRoteiroCliente = tamanhoPrevistoPFRoteiroCliente;
	}
	public int getTamanhoRealizadoPFRoteiroCliente() {
		return tamanhoRealizadoPFRoteiroCliente;
	}
	public void setTamanhoRealizadoPFRoteiroCliente(int tamanhoRealizadoPFRoteiroCliente) {
		this.tamanhoRealizadoPFRoteiroCliente = tamanhoRealizadoPFRoteiroCliente;
	}
	public EnumTipoDemanda getTipoDemanda() {
		return tipoDemanda;
	}
	public void setTipoDemanda(EnumTipoDemanda tipoDemanda) {
		this.tipoDemanda = tipoDemanda;
	}
	public EnumProcessoDesenvolvimento getTipoProcesso() {
		return tipoProcesso;
	}
	public void setTipoProcesso(EnumProcessoDesenvolvimento tipoProcesso) {
		this.tipoProcesso = tipoProcesso;
	}
	public EnumCicloVida getCiloVida() {
		return ciloVida;
	}
	public void setCiloVida(EnumCicloVida ciloVida) {
		this.ciloVida = ciloVida;
	}
	public String getUg() {
		return ug;
	}
	public void setUg(String ug) {
		this.ug = ug;
	}
	public String getLotacao() {
		return lotacao;
	}
	public void setLotacao(String lotacao) {
		this.lotacao = lotacao;
	}
	public String getUgDemandante() {
		return ugDemandante;
	}
	public void setUgDemandante(String ugDemandante) {
		this.ugDemandante = ugDemandante;
	}
	public Date getDataInicioRealizada() {
		return dataInicioRealizada;
	}
	public void setDataInicioRealizada(Date dataInicioRealizada) {
		this.dataInicioRealizada = dataInicioRealizada;
	}
	public Date getDataTerminoPrevista() {
		return dataTerminoPrevista;
	}
	public void setDataTerminoPrevista(Date dataTerminoPrevista) {
		this.dataTerminoPrevista = dataTerminoPrevista;
	}
	public Date getDataTerminoRealizada() {
		return dataTerminoRealizada;
	}
	public void setDataTerminoRealizada(Date dataTerminoRealizada) {
		this.dataTerminoRealizada = dataTerminoRealizada;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
