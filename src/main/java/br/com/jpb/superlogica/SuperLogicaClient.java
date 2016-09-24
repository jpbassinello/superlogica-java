package br.com.jpb.superlogica;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import javax.ws.rs.Encoded;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Encoded
final class SuperLogicaClient {

	private static final String DEFAULT_CHARSET = "UTF-8";
	private static final int TIMEOUT = 20000;

	private final String appToken;
	private final String accessToken;
	private final SuperLogicaApiVersion apiVersion = SuperLogicaApiVersion.V2;
	private String endpoint;
	private String httpMethod;
	private MultivaluedMap<String, String> mapParameters = new MultivaluedMapImpl();

	private SuperLogicaClient(String appToken, String accessToken) {
		this.appToken = appToken;
		this.accessToken = accessToken;
	}

	static SuperLogicaClient build(String appToken, String accessToken) {
		return new SuperLogicaClient(appToken, accessToken);
	}

	SuperLogicaClient withEndpoint(SuperLogicaEndpoint endpoint, Object... pathParameters) {
		this.endpoint = endpoint.getEndpoint(pathParameters);
		this.httpMethod = endpoint.getHttpMethod();
		return this;
	}

	SuperLogicaClient withDirectEndpointUrl(String directEndpointUrl, String httpMethod) {
		this.endpoint = directEndpointUrl;
		this.httpMethod = httpMethod;
		return this;
	}

	<T> SuperLogicaClient withObjectParameter(T t, boolean upperCaseParameterKeys) {

		ObjectMapper mapper = new ObjectMapper();
		TypeReference<HashMap<String, String>> typeRef = new TypeReference<HashMap<String, String>>() {};
		Map<String, String> convertValue = mapper.convertValue(t, typeRef);
		convertValue.entrySet().forEach(entry -> {
			mapParameters.put(upperCaseParameterKeys ? entry.getKey().toUpperCase() : entry.getKey(),
					Arrays.asList(entry.getValue()));
		});
		return this;
	}

	<T> T getResultList(GenericType<T> returnGenericType) {
		ClientResponse response = makeRequest();
		if (returnGenericType == null) {
			return null;
		}
		T readEntity = response.getEntity(returnGenericType);
		reset();
		return readEntity;
	}

	<T> T getSingleResult(Class<T> returnType) {
		ClientResponse response = makeRequest();
		if (returnType == null) {
			return null;
		}
		T readEntity = response.getEntity(returnType);
		reset();
		return readEntity;
	}

	private void reset() {
		this.endpoint = null;
		this.httpMethod = null;
		this.mapParameters = new MultivaluedMapImpl();
	}

	private ClientResponse makeRequest() {

		WebResource webResource = buildClient().resource(apiVersion.getFullUrl(endpoint));

		return webResource.header("Content-Type", "text/plain;charset=" + DEFAULT_CHARSET)
				.header("charset", DEFAULT_CHARSET).header("Content-Encoding", DEFAULT_CHARSET)
				.header("app_token", appToken).header("access_token", accessToken).type(MediaType.APPLICATION_JSON)
				.type(MediaType.APPLICATION_FORM_URLENCODED).method(httpMethod, ClientResponse.class, mapParameters);
	}

	private Client buildClient() {
		final DefaultClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(clientConfig);
		client.setConnectTimeout(TIMEOUT);
		client.setReadTimeout(TIMEOUT);

		return client;
	}
}