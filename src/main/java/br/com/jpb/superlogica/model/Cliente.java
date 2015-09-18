package br.com.jpb.superlogica.model;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import br.com.jpb.JsonUtil;
import br.com.jpb.jackson.databind.CustomLocalDateDeserializer;
import br.com.jpb.jackson.databind.CustomLocalDateSerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
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

	public Cliente(String nomeOuRazaoSocial, String nomeFantasia,
			int diaVencimento) {
		this.nomeOuRazaoSocial = nomeOuRazaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.diaVencimento = diaVencimento;
	}

	protected Integer getId() {
		return id;
	}

	protected void setId(Integer id) {
		this.id = id;
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

	protected int getDiaVencimento() {
		return diaVencimento;
	}

	protected void setDiaVencimento(int diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	protected String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	protected String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	protected String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}

	protected String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	protected void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	protected String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	protected void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	protected String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	protected String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	protected String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	protected String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	protected String getEndereco() {
		return endereco;
	}

	protected void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	protected String getNumero() {
		return numero;
	}

	protected void setNumero(String numero) {
		this.numero = numero;
	}

	protected String getComplemento() {
		return complemento;
	}

	protected void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	protected String getBairro() {
		return bairro;
	}

	protected void setBairro(String bairro) {
		this.bairro = bairro;
	}

	protected String getCidade() {
		return cidade;
	}

	protected void setCidade(String cidade) {
		this.cidade = cidade;
	}

	protected String getEstado() {
		return estado;
	}

	protected void setEstado(String estado) {
		this.estado = estado;
	}

	protected String getCep() {
		return cep;
	}

	protected void setCep(String cep) {
		this.cep = cep;
	}

	protected Integer getDesabilitarMensalidade() {
		return desabilitarMensalidade;
	}

	protected void setDesabilitarMensalidade(Integer desabilitarMensalidade) {
		this.desabilitarMensalidade = desabilitarMensalidade;
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

	protected Integer getDesativar() {
		return desativar;
	}

	protected void setDesativar(Integer desativar) {
		this.desativar = desativar;
	}

	protected int getStatus() {
		return status;
	}

	protected void setStatus(int status) {
		this.status = status;
	}

	protected Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	protected Date getDataCadastro() {
		return dataCadastro;
	}

	protected void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	protected Date getDataAlteracao() {
		return dataAlteracao;
	}

	protected void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	protected String getUrlFormaDePagamento() {
		return urlFormaDePagamento;
	}

	protected void setUrlFormaDePagamento(String urlFormaDePagamento) {
		this.urlFormaDePagamento = urlFormaDePagamento;
	}

	protected String getUrlAreaDoCliente() {
		return urlAreaDoCliente;
	}

	protected void setUrlAreaDoCliente(String urlAreaDoCliente) {
		this.urlAreaDoCliente = urlAreaDoCliente;
	}

	@Override
	public String toString() {
		return JsonUtil.serialize(this);
	}

}