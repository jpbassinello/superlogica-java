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
public final class Assinatura implements Serializable {

	@JsonProperty("id_planocliente_plc")
	private int idAssinatura;

	@JsonProperty("planos[0][id_sacado_sac]")
	private int idCliente;

	@JsonProperty("planos[0][id_plano_pla]")
	private int idPlano;

	@JsonProperty("planos[0][dt_contrato_plc]")
	@JsonDeserialize(using = CustomLocalDateDeserializer.class)
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	private Date dataContratacao;

	@JsonProperty("planos[0][fl_notificarcliente]")
	private int flNotificarCliente = 0;

	protected Assinatura() {
	}

	private Assinatura(int idCliente, int idPlano, Date dataContratacao) {
		this.idCliente = idCliente;
		this.idPlano = idPlano;
		this.dataContratacao = dataContratacao;
	}

	public static Assinatura assinaturaHoje(int idCliente, int idPlano) {
		return new Assinatura(idCliente, idPlano, new Date());
	}

	public static Assinatura assinaturaComData(int idCliente, int idPlano, Date data) {
		return new Assinatura(idCliente, idPlano, data);
	}

	public Assinatura comNotificacaoAoCliente() {
		this.flNotificarCliente = 1;
		return this;
	}

	@Override
	public String toString() {
		return JsonUtil.serialize(this);
	}
}