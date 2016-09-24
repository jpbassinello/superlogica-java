package br.com.jpb.superlogica.model;

import br.com.jpb.JsonUtil;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
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

	@Override
	public String toString() {
		return JsonUtil.serialize(this);
	}

}