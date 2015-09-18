package br.com.jpb.superlogica.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import br.com.jpb.JsonUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class Checkout implements Serializable {
	private static final int PAGAMENTO_BOLETO = 0;
	private static final int PAGAMENTO_CARTAO_CREDITO = 3;
	// private static final int PAGAMENTO_CARTO_DEBITO = 7;

	@JsonProperty("idplano")
	private int idPlano;
	@JsonProperty("ST_NOME_SAC")
	private String nomeOuRazaoSocial;
	@JsonProperty("ST_EMAIL_SAC")
	private String email;
	@JsonProperty("FL_PAGAMENTOPREF_SAC")
	private int idFormaPagamento;
	@JsonProperty("senha")
	private String senha;
	@JsonProperty("senha_confirmacao")
	private String confirmacaoSenha;
	@JsonProperty("ST_CGC_SAC")
	private String cpfCnpj;
	@JsonProperty("ST_TELEFONE_SAC")
	private String telefone;
	@JsonProperty("ST_ENDERECO_SAC")
	private String endereco;
	@JsonProperty("ST_NUMERO_SAC")
	private String numero;
	@JsonProperty("ST_COMPLEMENTO_SAC")
	private String complemento;
	@JsonProperty("ST_BAIRRO_SAC")
	private String bairro;
	@JsonProperty("ST_CIDADE_SAC")
	private String cidade;
	@JsonProperty("ST_ESTADO_SAC")
	private String estado;
	@JsonProperty("ST_CEP_SAC")
	private String cep;
	@JsonProperty("ST_CARTAO_SAC")
	private String numeroCartao;
	@JsonProperty("ST_MESVALIDADE_SAC")
	private Integer mesVencimentoCartao;
	@JsonProperty("ST_ANOVALIDADE_SAC")
	private Integer anoVencimentoCartao;
	@JsonProperty("ST_SEGURANCACARTAO_SAC")
	private Integer codigoSegurancaCartao;
	@JsonProperty("ST_NOMECARTAO_SAC")
	private String nomeImpressoCartao;
	@JsonProperty("ST_CARTAOBANDEIRA_SAC")
	private String bandeiraCartao;

	protected Checkout() {
	}

	private Checkout(int idPlano, String nomeOuRazaoSocial, String email,
			int idFormaPagamento, String senha, String confirmacaoSenha,
			String cpfCnpj, String telefone) {
		this.idPlano = idPlano;
		this.nomeOuRazaoSocial = nomeOuRazaoSocial;
		this.email = email;
		this.idFormaPagamento = idFormaPagamento;
		this.senha = senha;
		this.confirmacaoSenha = confirmacaoSenha;
		this.cpfCnpj = cpfCnpj;
		this.telefone = telefone;
	}

	private Checkout(int idPlano, String nomeOuRazaoSocial, String email,
			int idFormaPagamento, String senha, String confirmacaoSenha,
			String numeroCartao, Integer mesVencimentoCartao,
			Integer anoVencimentoCartao, Integer codigoSegurancaCartao,
			String nomeImpressoCartao, String bandeiraCartao, String cpfCnpj,
			String telefone) {
		this(idPlano, nomeOuRazaoSocial, email, idFormaPagamento, senha,
				confirmacaoSenha, cpfCnpj, telefone);
		this.numeroCartao = numeroCartao;
		this.mesVencimentoCartao = mesVencimentoCartao;
		this.anoVencimentoCartao = anoVencimentoCartao;
		this.codigoSegurancaCartao = codigoSegurancaCartao;
		this.nomeImpressoCartao = nomeImpressoCartao;
		this.bandeiraCartao = bandeiraCartao;
	}

	public static Checkout novoCheckoutComBoleto(int idPlano,
			String nomeOuRazaoSocial, String email, String senha,
			String confirmacaoSenha, String cpfCnpj, String telefone) {
		return new Checkout(idPlano, nomeOuRazaoSocial, email, PAGAMENTO_BOLETO,
				senha, confirmacaoSenha, cpfCnpj, telefone);
	}

	public static Checkout novoCheckoutComCartao(int idPlano,
			String nomeOuRazaoSocial, String email, String senha,
			String confirmacaoSenha, String numeroCartao,
			Integer mesVencimentoCartao, Integer anoVencimentoCartao,
			Integer codigoSegurancaCartao, String nomeImpressoCartao,
			String bandeiraCartao, String cpfCnpj, String telefone) {
		return new Checkout(idPlano, nomeOuRazaoSocial, email,
				PAGAMENTO_CARTAO_CREDITO, senha, confirmacaoSenha, numeroCartao,
				mesVencimentoCartao, anoVencimentoCartao, codigoSegurancaCartao,
				nomeImpressoCartao, bandeiraCartao, cpfCnpj, telefone);
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

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	protected int getIdFormaPagamento() {
		return idFormaPagamento;
	}

	protected void setIdFormaPagamento(int idFormaPagamento) {
		this.idFormaPagamento = idFormaPagamento;
	}

	protected String getSenha() {
		return senha;
	}

	protected void setSenha(String senha) {
		this.senha = senha;
	}

	protected String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	protected void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

	protected String getCpfCnpj() {
		return cpfCnpj;
	}

	protected void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	protected String getTelefone() {
		return telefone;
	}

	protected void setTelefone(String telefone) {
		this.telefone = telefone;
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