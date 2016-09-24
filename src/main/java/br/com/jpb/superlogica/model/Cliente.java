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
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public final class Cliente implements Serializable {
	@JsonProperty("id_sacado_sac")
	private Integer id;
	@JsonProperty("st_nome_sac")
	private String nomeOuRazaoSocial;
	@JsonProperty("st_nomeref_sac")
	private String nomeFantasia;
	@JsonProperty("st_diavencimento_sac")
	private int diaVencimento;
	@JsonProperty("st_cgc_sac")
	private String cpfCnpj;
	@JsonProperty("st_rg_sac")
	private String rg;
	@JsonProperty("st_orgao_sac")
	private String orgaoExpedidor;
	@JsonProperty("st_inscmunicipal_sac")
	private String inscricaoMunicipal;
	@JsonProperty("st_inscricao_sac")
	private String inscricaoEstadual;
	@JsonProperty("st_email_sac")
	private String email;
	@JsonProperty("st_telefone_sac")
	private String telefone;
	@JsonProperty("st_celular_sac")
	private String celular;
	@JsonProperty("st_fax_sac")
	private String fax;
	@JsonProperty("st_endereco_sac")
	private String endereco;
	@JsonProperty("st_numero_sac")
	private String numero;
	@JsonProperty("st_complemento_sac")
	private String complemento;
	@JsonProperty("st_bairro_sac")
	private String bairro;
	@JsonProperty("st_cidade_sac")
	private String cidade;
	@JsonProperty("st_estado_sac")
	private String estado;
	@JsonProperty("st_cep_sac")
	private String cep;
	@JsonProperty("desabilitar_mensalidade")
	private Integer desabilitarMensalidade;
	@JsonProperty("nm_cartao_sac")
	private String numeroCartao;
	@JsonProperty("nm_mescartaovencimento_sac")
	private Integer mesVencimentoCartao;
	@JsonProperty("nm_anocartaovencimento_sac")
	private Integer anoVencimentoCartao;
	@JsonProperty("st_cartaobandeira_sac")
	private String bandeiraCartao;
	@JsonProperty("fl_desativar_sac")
	private Integer desativar;
	@JsonProperty("fl_status_sac")
	private int status;
	@JsonProperty("dt_nascimento_sac")
	@JsonDeserialize(using = CustomLocalDateDeserializer.class)
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	private Date dataNascimento;
	@JsonProperty("dt_cadastro_sac")
	@JsonDeserialize(using = CustomLocalDateDeserializer.class)
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	private Date dataCadastro;
	@JsonProperty("dt_alteracao_sincro")
	@JsonDeserialize(using = CustomLocalDateDeserializer.class)
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	private Date dataAlteracao;
	@JsonProperty("urlFormaDePagamento")
	private String urlFormaDePagamento;
	@JsonProperty("urlAreaDoCliente")
	private String urlAreaDoCliente;

	protected Cliente() {
	}

	private Cliente(String nomeOuRazaoSocial, String nomeFantasia, int diaVencimento) {
		this.nomeOuRazaoSocial = nomeOuRazaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.diaVencimento = diaVencimento;
	}

	public static Cliente novoPf(String nome, int diaVencimento) {
		return new Cliente(nome, null, diaVencimento);
	}

	public static Cliente novoPj(String razaoSocial, String nomeFantasia, int diaVencimento) {
		return new Cliente(razaoSocial, nomeFantasia, diaVencimento);
	}

	@Override
	public String toString() {
		return JsonUtil.serialize(this);
	}

}