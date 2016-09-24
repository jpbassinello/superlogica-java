package br.com.jpb.superlogica.model;

import br.com.jpb.JsonUtil;
import br.com.jpb.jackson.databind.CustomLocalDateDeserializer;
import br.com.jpb.jackson.databind.CustomLocalDateSerializer;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public final class CancelarAssinatura implements Serializable {

	@JsonProperty("id_planocliente_plc")
	private int idAssinatura;
	@JsonProperty("dt_cancelamento_plc")
	@JsonDeserialize(using = CustomLocalDateDeserializer.class)
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	private Date dataCancelamento;
	@JsonProperty("fl_cancelamentoimediato")
	private int flCancelamentoImediato;

	protected CancelarAssinatura() {
	}

	private CancelarAssinatura(int idAssinatura, Date dataCancelamento, int flCancelamentoImediato) {
		this.idAssinatura = idAssinatura;
		this.dataCancelamento = dataCancelamento;
		this.flCancelamentoImediato = flCancelamentoImediato;
	}

	public static CancelarAssinatura cancelarImediato(int idAssinatura) {
		return new CancelarAssinatura(idAssinatura, new Date(), 1);
	}

	@Override
	public String toString() {
		return JsonUtil.serialize(this);
	}
}