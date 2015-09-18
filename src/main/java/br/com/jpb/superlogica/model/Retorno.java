package br.com.jpb.superlogica.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import br.com.jpb.JsonUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class Retorno implements Serializable {

	@JsonProperty("status")
	private String status;
	@JsonProperty("msg")
	private String msg;
	@JsonProperty("data")
	private Object data;

	protected Retorno() {
	}

	public String getStatus() {
		return status;
	}

	protected void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	protected void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	protected void setData(Object data) {
		this.data = data;
	}

	public boolean isSucesso() {
		return "200".equals(status) || "201".equals(status);
	}

	@Override
	public String toString() {
		return JsonUtil.serialize(this);
	}

}
