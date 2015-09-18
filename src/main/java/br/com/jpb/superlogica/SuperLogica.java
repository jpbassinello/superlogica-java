package br.com.jpb.superlogica;

import java.util.List;

import javax.ws.rs.core.GenericType;

import br.com.jpb.JsonUtil;
import br.com.jpb.superlogica.model.Assinatura;
import br.com.jpb.superlogica.model.Checkout;
import br.com.jpb.superlogica.model.Cliente;
import br.com.jpb.superlogica.model.Cobranca;
import br.com.jpb.superlogica.model.RespostaCheckout;
import br.com.jpb.superlogica.model.Retorno;

public final class SuperLogica {

	private final SuperLogicaClient client;

	public SuperLogica(String appToken, String accessToken) {
		this.client = SuperLogicaClient.build(appToken, accessToken);
	}

	public List<Cliente> listarClientes() {
		return listar(new GenericType<List<Cliente>>() {
		}, SuperLogicaEndpoint.LISTA_CLIENTES);
	}

	public Cliente cadastarCliente(Cliente cliente)
			throws SuperlogicaApiException {
		return chamarOperacoesComRetorno(cliente, Cliente.class,
				SuperLogicaEndpoint.CADASTRO_CLIENTE);
	}

	public Cliente editarCliente(Cliente cliente)
			throws SuperlogicaApiException {
		return chamarOperacoesComRetorno(cliente, Cliente.class,
				SuperLogicaEndpoint.EDICAO_CLIENTE);
	}

	public Cliente listarClientePorId(int id) {
		return listarPorId(id, new GenericType<List<Cliente>>() {
		}, SuperLogicaEndpoint.LISTA_CLIENTE_POR_ID);
	}

	public List<Cobranca> listarCobrancas() {
		return listar(new GenericType<List<Cobranca>>() {
		}, SuperLogicaEndpoint.LISTA_COBRANCAS);
	}

	public Cobranca cadastrarCobranca(Cobranca cobranca)
			throws SuperlogicaApiException {
		return chamarOperacoesComRetorno(cobranca, Cobranca.class,
				SuperLogicaEndpoint.CADASTRO_COBRANCA);
	}

	public Cobranca editarCobranca(Cobranca cobranca)
			throws SuperlogicaApiException {
		return chamarOperacoesComRetorno(cobranca, Cobranca.class,
				SuperLogicaEndpoint.EDICAO_COBRANCA);
	}

	public Cobranca listarCobrancaPorId(int id) {
		return listarPorId(id, new GenericType<List<Cobranca>>() {
		}, SuperLogicaEndpoint.LISTA_COBRANCA_POR_ID);
	}

	public Cobranca liquidarCobranca(Cobranca cobranca)
			throws SuperlogicaApiException {
		return chamarOperacoesComRetorno(cobranca, Cobranca.class,
				SuperLogicaEndpoint.LIQUIDACAO_COBRANCA);
	}

	public Assinatura assinarPlano(Assinatura assinatura)
			throws SuperlogicaApiException {
		return chamarOperacoesComRetorno(assinatura, Assinatura.class,
				SuperLogicaEndpoint.CONTRATACAO_ASSINATURA);
	}

	public RespostaCheckout fazerCheckoutPlano(Checkout checkout)
			throws SuperlogicaApiException {
		RespostaCheckout resposta = client
				.withEndpoint(SuperLogicaEndpoint.CHECKOUT)
				.withObjectParameter(checkout, false)
				.getResultList(new GenericType<RespostaCheckout>() {
				});

		String msg = resposta.getMsg();
		if (msg != null && !msg.trim().isEmpty()) {
			throw new SuperlogicaApiException(SuperLogicaEndpoint.CHECKOUT,
					"500", msg);
		}

		return resposta;
	}

	public <T> List<T> listar(GenericType<List<T>> genericType,
			SuperLogicaEndpoint endpoint) {
		return client.withEndpoint(endpoint).getResultList(genericType);
	}

	private <T> T chamarOperacoesComRetorno(T t, Class<T> type,
			SuperLogicaEndpoint endpoint) throws SuperlogicaApiException {
		return chamarOperacoesComRetorno(t, type, endpoint, true);
	}

	private <T> T chamarOperacoesComRetorno(T t, Class<T> type,
			SuperLogicaEndpoint endpoint, boolean upperCaseParameterKeys)
					throws SuperlogicaApiException {
		List<Retorno> retornos = client.withEndpoint(endpoint)
				.withObjectParameter(t, upperCaseParameterKeys)
				.getResultList(new GenericType<List<Retorno>>() {
				});

		Retorno retorno = retornos.get(0);
		validaRetorno(endpoint, retorno);

		return JsonUtil.deserialize(retorno.getData(), type);
	}

	private <T> T listarPorId(int id, GenericType<List<T>> genericType,
			SuperLogicaEndpoint endpoint) {
		return client.withEndpoint(endpoint, Integer.valueOf(id).toString())
				.getResultList(genericType).get(0);
	}

	private void validaRetorno(SuperLogicaEndpoint endpoint, Retorno retorno)
			throws SuperlogicaApiException {
		if (!retorno.isSucesso()) {
			throw new SuperlogicaApiException(endpoint, retorno.getStatus(),
					retorno.getMsg());
		}
	}

}
