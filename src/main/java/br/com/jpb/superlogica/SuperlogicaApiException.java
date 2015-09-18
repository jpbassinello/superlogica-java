package br.com.jpb.superlogica;

public final class SuperlogicaApiException extends Exception {

	private final SuperLogicaEndpoint endpoint;
	private final String apiStatus;
	private final String apiMsg;

	public SuperlogicaApiException(SuperLogicaEndpoint endpoint,
			String apiStatus, String apiMsg) {
		super(String.format(
				"Ocorreu um erro na chamada a api do Superlógica. Endpoint: %s. Status: %s. Mensagem: %s",
				endpoint, apiStatus, apiMsg));
		this.endpoint = endpoint;
		this.apiStatus = apiStatus;
		this.apiMsg = apiMsg;
	}

	public SuperLogicaEndpoint getEndpoint() {
		return endpoint;
	}

	public String getApiMsg() {
		return apiMsg;
	}

	public String getApiStatus() {
		return apiStatus;
	}
}
