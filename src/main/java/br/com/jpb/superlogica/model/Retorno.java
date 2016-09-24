package br.com.jpb.superlogica.model;

import br.com.jpb.JsonUtil;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public final class Retorno implements Serializable {

	@JsonProperty("status")
	private String status;
	@JsonProperty("msg")
	private String msg;
	@JsonProperty("data")
	private Object data;

	protected Retorno() {
	}

	public boolean isSucesso() {
		return "200".equals(status) || "201".equals(status);
	}

	@Override
	public String toString() {
		return JsonUtil.serialize(this);
	}

}
