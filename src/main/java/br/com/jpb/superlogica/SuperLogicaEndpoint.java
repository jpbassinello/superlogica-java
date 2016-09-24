package br.com.jpb.superlogica;

import javax.ws.rs.HttpMethod;

public enum SuperLogicaEndpoint {
	LISTA_CLIENTES("/financeiro/clientes", HttpMethod.GET),
	CADASTRO_CLIENTE("/financeiro/clientes", HttpMethod.POST),
	EDICAO_CLIENTE("/financeiro/clientes", HttpMethod.PUT),
	LISTA_CLIENTE_POR_ID("/financeiro/clientes/%s", HttpMethod.GET),
	FORMA_DE_PAGAMENTO_CLIENTE("financeiro/clientes/formadepagamento", HttpMethod.PUT),
	LISTA_COBRANCAS("/financeiro/cobranca", HttpMethod.GET),
	CADASTRO_COBRANCA("/financeiro/cobranca", HttpMethod.POST),
	EDICAO_COBRANCA("/financeiro/cobranca", HttpMethod.PUT),
	LISTA_COBRANCA_POR_ID("/financeiro/cobranca/%s", HttpMethod.GET),
	LIQUIDACAO_COBRANCA("financeiro/cobranca/liquidar", HttpMethod.PUT),
	CONTRATACAO_ASSINATURA("/financeiro/assinaturas", HttpMethod.POST),
	CANCELAMENTO_ASSINATURA("/financeiro/assinaturas", HttpMethod.PUT),
	CHECKOUT("/financeiro/checkout", HttpMethod.POST);

	private final String endpoint;
	private final String httpMethod;

	SuperLogicaEndpoint(String endpoint, String httpMethod) {
		this.endpoint = endpoint;
		this.httpMethod = httpMethod;
	}

	public String getEndpoint(Object... pathParameters) {
		if (pathParameters == null || pathParameters.length == 0) {
			return endpoint;
		}
		return String.format(endpoint, pathParameters);
	}

	public String getHttpMethod() {
		return httpMethod;
	}
}
