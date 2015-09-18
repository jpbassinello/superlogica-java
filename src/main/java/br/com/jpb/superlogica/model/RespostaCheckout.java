package br.com.jpb.superlogica.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import br.com.jpb.JsonUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class RespostaCheckout implements Serializable {
	@JsonProperty("id_plano_pla")
	private int idPlano;
	@JsonProperty("st_nome_sac")
	private String nomeOuRazaoSocial;
	@JsonProperty("st_nomeref_sac")
	private String nomeFantasia;
	@JsonProperty("st_cgc_sac")
	private String cpfCnpj;
	@JsonProperty("st_email_sac")
	private String email;
	@JsonProperty("st_telefone_sac")
	private String telefone;
	@JsonProperty("valor_primeira_cobranca")
	private BigDecimal valorPrimeiraCobranca;
	@JsonProperty("link_boleto")
	private String linkBoleto;
	@JsonProperty("valor_boleto")
	private BigDecimal valorBoleto;
	@JsonProperty("urlcallback")
	private String urlCallback;
	@JsonProperty("msg")
	private String msg;

	protected RespostaCheckout() {
	}

	protected int getIdPlano() {
		return idPlano;
	}

	protected void setIdPlano(int idPlano) {
		this.idPlano = idPlano;
	}

	protected String getNomeOuRazaoSocial() {
		return nomeOuRazaoSocial;
	}

	protected void setNomeOuRazaoSocial(String nomeOuRazaoSocial) {
		this.nomeOuRazaoSocial = nomeOuRazaoSocial;
	}

	protected String getNomeFantasia() {
		return nomeFantasia;
	}

	protected void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	protected String getCpfCnpj() {
		return cpfCnpj;
	}

	protected void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	protected String getTelefone() {
		return telefone;
	}

	protected void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	protected BigDecimal getValorPrimeiraCobranca() {
		return valorPrimeiraCobranca;
	}

	protected void setValorPrimeiraCobranca(BigDecimal valorPrimeiraCobranca) {
		this.valorPrimeiraCobranca = valorPrimeiraCobranca;
	}

	protected String getLinkBoleto() {
		return linkBoleto;
	}

	protected void setLinkBoleto(String linkBoleto) {
		this.linkBoleto = linkBoleto;
	}

	protected BigDecimal getValorBoleto() {
		return valorBoleto;
	}

	protected void setValorBoleto(BigDecimal valorBoleto) {
		this.valorBoleto = valorBoleto;
	}

	protected String getUrlCallback() {
		return urlCallback;
	}

	protected void setUrlCallback(String urlCallback) {
		this.urlCallback = urlCallback;
	}

	public String getMsg() {
		return msg;
	}
	
	protected void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return JsonUtil.serialize(this);
	}

}