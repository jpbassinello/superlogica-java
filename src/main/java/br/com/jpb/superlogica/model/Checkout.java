package br.com.jpb.superlogica.model;

import br.com.jpb.JsonUtil;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
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

	private Checkout(int idPlano, String nomeOuRazaoSocial, String email, int idFormaPagamento, String senha,
			String confirmacaoSenha, String cpfCnpj, String telefone) {
		this.idPlano = idPlano;
		this.nomeOuRazaoSocial = nomeOuRazaoSocial;
		this.email = email;
		this.idFormaPagamento = idFormaPagamento;
		this.senha = senha;
		this.confirmacaoSenha = confirmacaoSenha;
		this.cpfCnpj = cpfCnpj;
		this.telefone = telefone;
	}

	private Checkout(int idPlano, String nomeOuRazaoSocial, String email, int idFormaPagamento, String senha,
			String confirmacaoSenha, String numeroCartao, Integer mesVencimentoCartao, Integer anoVencimentoCartao,
			Integer codigoSegurancaCartao, String nomeImpressoCartao, String bandeiraCartao, String cpfCnpj,
			String telefone) {
		this(idPlano, nomeOuRazaoSocial, email, idFormaPagamento, senha, confirmacaoSenha, cpfCnpj, telefone);
		this.numeroCartao = numeroCartao;
		this.mesVencimentoCartao = mesVencimentoCartao;
		this.anoVencimentoCartao = anoVencimentoCartao;
		this.codigoSegurancaCartao = codigoSegurancaCartao;
		this.nomeImpressoCartao = nomeImpressoCartao;
		this.bandeiraCartao = bandeiraCartao;
	}

	public static Checkout novoCheckoutComBoleto(int idPlano, Cliente cliente, String senha, String confirmacaoSenha) {
		return novoCheckoutComBoleto(idPlano, cliente.getNomeOuRazaoSocial(), cliente.getEmail(), senha,
				confirmacaoSenha, cliente.getCpfCnpj(), cliente.getTelefone());
	}

	public static Checkout novoCheckoutComBoleto(int idPlano, String nomeOuRazaoSocial, String email, String senha,
			String confirmacaoSenha, String cpfCnpj, String telefone) {
		return new Checkout(idPlano, nomeOuRazaoSocial, email, PAGAMENTO_BOLETO, senha, confirmacaoSenha, cpfCnpj,
				telefone);
	}

	public static Checkout novoCheckoutComCartao(int idPlano, Cliente cliente, String senha, String confirmacaoSenha,
			String numeroCartao, Integer mesVencimentoCartao, Integer anoVencimentoCartao,
			Integer codigoSegurancaCartao, String nomeImpressoCartao, String bandeiraCartao) {
		return new Checkout(idPlano, cliente.getNomeOuRazaoSocial(), cliente.getEmail(), PAGAMENTO_CARTAO_CREDITO,
				senha, confirmacaoSenha, numeroCartao, mesVencimentoCartao, anoVencimentoCartao, codigoSegurancaCartao,
				nomeImpressoCartao, bandeiraCartao, cliente.getCpfCnpj(), cliente.getTelefone());
	}

	public static Checkout novoCheckoutComCartao(int idPlano, String nomeOuRazaoSocial, String email, String senha,
			String confirmacaoSenha, String numeroCartao, Integer mesVencimentoCartao, Integer anoVencimentoCartao,
			Integer codigoSegurancaCartao, String nomeImpressoCartao, String bandeiraCartao, String cpfCnpj,
			String telefone) {
		return new Checkout(idPlano, nomeOuRazaoSocial, email, PAGAMENTO_CARTAO_CREDITO, senha, confirmacaoSenha,
				numeroCartao, mesVencimentoCartao, anoVencimentoCartao, codigoSegurancaCartao, nomeImpressoCartao,
				bandeiraCartao, cpfCnpj, telefone);
	}

	@Override
	public String toString() {
		return JsonUtil.serialize(this);
	}

}