package br.com.jpb.superlogica.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import br.com.jpb.JsonUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class FormaPagamento implements Serializable {
	@JsonProperty("id_sacado_sac")
	private int idCliente;
	@JsonProperty("fl_pagamentopref_sac")
	private int flgPagamentoPref;
	@JsonProperty("st_cartao_sac")
	private String numeroCartao;
	@JsonProperty("st_mesvalidade_sac")
	private Integer mesVencimentoCartao;
	@JsonProperty("st_anovalidade_sac")
	private Integer anoVencimentoCartao;
	@JsonProperty("st_segurancacartao_sac")
	private Integer codigoSegurancaCartao;
	@JsonProperty("st_nomecartao_sac")
	private String nomeImpressoCartao;
	@JsonProperty("st_cartaobandeira_sac")
	private String bandeiraCartao;

	protected FormaPagamento() {
	}

	public static FormaPagamento novaFormaCartaoCredito(int idCliente,
			String numeroCartao, Integer mesVencimentoCartao,
			Integer anoVencimentoCartao, Integer codigoSegurancaCartao,
			String nomeImpressoCartao, String bandeiraCartao) {
		FormaPagamento formaPagamento = new FormaPagamento();
		formaPagamento.idCliente = idCliente;
		formaPagamento.flgPagamentoPref = 3;
		formaPagamento.numeroCartao = numeroCartao;
		formaPagamento.mesVencimentoCartao = mesVencimentoCartao;
		formaPagamento.anoVencimentoCartao = anoVencimentoCartao;
		formaPagamento.codigoSegurancaCartao = codigoSegurancaCartao;
		formaPagamento.nomeImpressoCartao = nomeImpressoCartao;
		formaPagamento.bandeiraCartao = bandeiraCartao;

		return formaPagamento;
	}

	public static FormaPagamento novaFormaBoleto(int idCliente) {
		FormaPagamento formaPagamento = new FormaPagamento();
		formaPagamento.idCliente = idCliente;
		formaPagamento.flgPagamentoPref = 0;

		return formaPagamento;
	}

	protected int getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	protected int getFlgPagamentoPref() {
		return flgPagamentoPref;
	}

	protected void setFlgPagamentoPref(int flgPagamentoPref) {
		this.flgPagamentoPref = flgPagamentoPref;
	}

	protected String getNumeroCartao() {
		return numeroCartao;
	}

	protected void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	protected Integer getMesVencimentoCartao() {
		return mesVencimentoCartao;
	}

	protected void setMesVencimentoCartao(Integer mesVencimentoCartao) {
		this.mesVencimentoCartao = mesVencimentoCartao;
	}

	protected Integer getAnoVencimentoCartao() {
		return anoVencimentoCartao;
	}

	protected void setAnoVencimentoCartao(Integer anoVencimentoCartao) {
		this.anoVencimentoCartao = anoVencimentoCartao;
	}

	protected Integer getCodigoSegurancaCartao() {
		return codigoSegurancaCartao;
	}

	protected void setCodigoSegurancaCartao(Integer codigoSegurancaCartao) {
		this.codigoSegurancaCartao = codigoSegurancaCartao;
	}

	protected String getNomeImpressoCartao() {
		return nomeImpressoCartao;
	}

	protected void setNomeImpressoCartao(String nomeImpressoCartao) {
		this.nomeImpressoCartao = nomeImpressoCartao;
	}

	protected String getBandeiraCartao() {
		return bandeiraCartao;
	}

	protected void setBandeiraCartao(String bandeiraCartao) {
		this.bandeiraCartao = bandeiraCartao;
	}

	@Override
	public String toString() {
		return JsonUtil.serialize(this);
	}
}