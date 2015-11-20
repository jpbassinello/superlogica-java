package br.com.jpb.superlogica;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.Encoded;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

@Encoded
final class SuperLogicaClient {

	private static final String DEFAULT_CHARSET = "UTF-8";

	private final String appToken;
	private final String accessToken;
	private final SuperLogicaApiVersion apiVersion = SuperLogicaApiVersion.V2;
	private String endpoint;
	private String httpMethod;
	private Entity<?> objectParameter;

	private SuperLogicaClient(String appToken, String accessToken) {
		this.appToken = appToken;
		this.accessToken = accessToken;
	}

	static SuperLogicaClient build(String appToken, String accessToken) {
		return new SuperLogicaClient(appToken, accessToken);
	}

	SuperLogicaClient withEndpoint(SuperLogicaEndpoint endpoint,
			Object... pathParameters) {
		this.endpoint = endpoint.getEndpoint(pathParameters);
		this.httpMethod = endpoint.getHttpMethod();
		return this;
	}

	SuperLogicaClient withDirectEndpointUrl(String directEndpointUrl,
			String httpMethod) {
		this.endpoint = directEndpointUrl;
		this.httpMethod = httpMethod;
		return this;
	}

	<T> SuperLogicaClient withObjectParameter(T t,
			boolean upperCaseParameterKeys) {
		final Form form = new Form();
		Annotation[] annotations = new Annotation[1];
		annotations[0] = this.getClass().getAnnotation(Encoded.class);
		this.objectParameter = (Entity<Form>) Entity.entity(form,
				MediaType.APPLICATION_FORM_URLENCODED_TYPE, annotations);

		ObjectMapper mapper = new ObjectMapper();
		TypeReference<HashMap<String, String>> typeRef = new TypeReference<HashMap<String, String>>() {
		};
		Map<String, String> convertValue = mapper.convertValue(t, typeRef);
		convertValue.entrySet().forEach(entry -> {
			form.param(upperCaseParameterKeys ? entry.getKey().toUpperCase()
					: entry.getKey(), entry.getValue());
		});
		return this;
	}

	<T> T getResultList(GenericType<T> returnGenericType) {
		Response response = makeRequest();
		if (returnGenericType == null) {
			return null;
		}
		T readEntity = response.readEntity(returnGenericType);
		reset();
		return readEntity;
	}

	<T> T getSingleResult(Class<T> returnType) {
		Response response = makeRequest();
		if (returnType == null) {
			return null;
		}
		T readEntity = response.readEntity(returnType);
		reset();
		return readEntity;
	}

	private void reset() {
		this.endpoint = null;
		this.httpMethod = null;
		this.objectParameter = null;
	}

	private Response makeRequest() {
		ResteasyClient client = buildClient();
		ResteasyWebTarget target = client
				.target(apiVersion.getFullUrl(endpoint));
		Response response = target.request(MediaType.APPLICATION_JSON)
				.header("Content-Type", "text/plain;charset=" + DEFAULT_CHARSET)
				.header("charset", DEFAULT_CHARSET)
				.header("Content-Encoding", DEFAULT_CHARSET)
				.header("app_token", appToken)
				.header("access_token", accessToken)
				.method(httpMethod, objectParameter);
		return response;
	}

	private ResteasyClient buildClient() {
		return new ResteasyClientBuilder()
				.establishConnectionTimeout(30, TimeUnit.SECONDS)
				.socketTimeout(60, TimeUnit.SECONDS).build();
	}

}