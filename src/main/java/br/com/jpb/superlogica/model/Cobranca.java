package br.com.jpb.superlogica.model;

import br.com.jpb.JsonUtil;
import br.com.jpb.jackson.databind.CustomLocalDateDeserializer;
import br.com.jpb.jackson.databind.CustomLocalDateSerializer;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
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

	public Cobranca(int idCliente, int idProdutoOuServico, int quantidade, BigDecimal valorUnitario,
			BigDecimal valorEmitido, Date dataVencimento) {
		super();
		this.idCliente = idCliente;
		this.idProdutoOuServico = idProdutoOuServico;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorEmitido = valorEmitido;
		this.dataVencimento = dataVencimento;
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