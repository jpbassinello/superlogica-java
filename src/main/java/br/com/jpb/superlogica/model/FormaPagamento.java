package br.com.jpb.superlogica.model;

import br.com.jpb.JsonUtil;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
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

	public static FormaPagamento novaFormaCartaoCredito(int idCliente, String numeroCartao, Integer
			mesVencimentoCartao,
			Integer anoVencimentoCartao, Integer codigoSegurancaCartao, String nomeImpressoCartao,
			String bandeiraCartao) {
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

	@Override
	public String toString() {
		return JsonUtil.serialize(this);
	}
}