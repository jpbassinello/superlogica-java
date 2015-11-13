package br.com.jpb.superlogica.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import br.com.jpb.JsonUtil;
import br.com.jpb.jackson.databind.CustomLocalDateDeserializer;
import br.com.jpb.jackson.databind.CustomLocalDateSerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class Cobranca implements Serializable {

	@JsonProperty("id_recebimento_recb")
	private Integer id;
	@JsonProperty("dt_recebimento_recb")
	@JsonDeserialize(using = CustomLocalDateDeserializer.class)
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	private Date dataRecebimento;
	@JsonProperty("dt_liquidacao_recb")
	@JsonDeserialize(using = CustomLocalDateDeserializer.class)
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	private Date dataLiquidacao;
	@JsonProperty("fl_status_recb")
	private Integer status;
	@JsonProperty("fl_pagamentopref_sac")
	private Integer idFormaPagamento;
	@JsonProperty("vl_total_recb")
	private BigDecimal valorTotalRecebimento;
	@JsonProperty("dt_cancelamento_recb")
	@JsonDeserialize(using = CustomLocalDateDeserializer.class)
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	private Date dataCancelamento;
	@JsonProperty("dt_geracao_recb")
	@JsonDeserialize(using = CustomLocalDateDeserializer.class)
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	private Date dataGeracao;
	@JsonProperty("st_md5_recb")
	private String md5;
	@JsonProperty("dt_impressao_recb")
	@JsonDeserialize(using = CustomLocalDateDeserializer.class)
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	private Date dataImpressao;
	@JsonProperty("id_nota_not")
	private String idNota;
	@JsonProperty("link_2via")
	private String link2Via;
	@JsonProperty("id_sacado_sac")
	private int idCliente;
	@JsonProperty("st_nome_sac")
	private String nomeOuRazaoSocial;
	@JsonProperty("st_nomeref_sac")
	private String nomeFantasia;
	@JsonProperty("nm_cartao_sac")
	private String numeroCartao;
	@JsonProperty("nm_mescartaovencimento_sac")
	private Integer mesVencimentoCartao;
	@JsonProperty("nm_anocartaovencimento_sac")
	private Integer anoVencimentoCartao;
	@JsonProperty("st_email_sac")
	private String email;
	@JsonProperty("st_telefone_sac")
	private String telefone;
	@JsonProperty("st_cep_sac")
	private String cep;
	@JsonProperty("compo_recebimento[0][id_produto_prd]")
	private int idProdutoOuServico;
	@JsonProperty("compo_recebimento[0][nm_quantidade_comp]")
	private int quantidade;
	@JsonProperty("compo_recebimento[0][vl_unitario_prd]")
	private BigDecimal valorUnitario;
	@JsonProperty("vl_emitido_recb")
	private BigDecimal valorEmitido;
	@JsonProperty("dt_vencimento_recb")
	@JsonDeserialize(using = CustomLocalDateDeserializer.class)
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	private Date dataVencimento;
	@JsonProperty("dt_alteracao_sincro")
	@JsonDeserialize(using = CustomLocalDateDeserializer.class)
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	private Date dataAlteracao;

	protected Cobranca() {
	}

	public Cobranca(int idCliente, int idProdutoOuServico, int quantidade,
			BigDecimal valorUnitario, BigDecimal valorEmitido,
			Date dataVencimento) {
		super();
		this.idCliente = idCliente;
		this.idProdutoOuServico = idProdutoOuServico;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorEmitido = valorEmitido;
		this.dataVencimento = dataVencimento;
	}

	protected Integer getId() {
		return id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	protected Date getDataRecebimento() {
		return dataRecebimento;
	}

	protected void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public Date getDataLiquidacao() {
		return dataLiquidacao;
	}

	protected void setDataLiquidacao(Date dataLiquidacao) {
		this.dataLiquidacao = dataLiquidacao;
	}

	public Integer getStatus() {
		return status;
	}

	protected void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIdFormaPagamento() {
		return idFormaPagamento;
	}

	protected void setIdFormaPagamento(Integer idFormaPagamento) {
		this.idFormaPagamento = idFormaPagamento;
	}

	protected BigDecimal getValorTotalRecebimento() {
		return valorTotalRecebimento;
	}

	protected void setValorTotalRecebimento(BigDecimal valorTotalRecebimento) {
		this.valorTotalRecebimento = valorTotalRecebimento;
	}

	protected Date getDataCancelamento() {
		return dataCancelamento;
	}

	protected void setDataCancelamento(Date dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}

	protected Date getDataGeracao() {
		return dataGeracao;
	}

	protected void setDataGeracao(Date dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	protected String getMd5() {
		return md5;
	}

	protected void setMd5(String md5) {
		this.md5 = md5;
	}

	protected Date getDataImpressao() {
		return dataImpressao;
	}

	protected void setDataImpressao(Date dataImpressao) {
		this.dataImpressao = dataImpressao;
	}

	protected String getIdNota() {
		return idNota;
	}

	protected void setIdNota(String idNota) {
		this.idNota = idNota;
	}

	public String getLink2Via() {
		return link2Via;
	}

	protected void setLink2Via(String link2Via) {
		this.link2Via = link2Via;
	}

	protected int getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

	protected String getCep() {
		return cep;
	}

	protected void setCep(String cep) {
		this.cep = cep;
	}

	protected int getIdProdutoOuServico() {
		return idProdutoOuServico;
	}

	protected void setIdProdutoOuServico(int idProdutoOuServico) {
		this.idProdutoOuServico = idProdutoOuServico;
	}

	protected int getQuantidade() {
		return quantidade;
	}

	protected void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	protected BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	protected void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	protected BigDecimal getValorEmitido() {
		return valorEmitido;
	}

	protected void setValorEmitido(BigDecimal valorEmitido) {
		this.valorEmitido = valorEmitido;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	protected void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	protected Date getDataAlteracao() {
		return dataAlteracao;
	}

	protected void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public void liquidar(Date data, BigDecimal valorTotalRecebimento) {
		this.dataRecebimento = data;
		this.dataLiquidacao = data;
		this.valorTotalRecebimento = valorTotalRecebimento;
	}

	@Override
	public String toString() {
		return JsonUtil.serialize(this);
	}
}