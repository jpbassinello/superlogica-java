package br.com.jpb;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public final class JsonUtil {
	private JsonUtil() {
	}

	public static <T> T deserialize(Object o, Class<T> t) {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(o, t);
	}

	public static String serialize(Object o) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
		try {
			return objectMapper.writeValueAsString(o);
		} catch (IOException e) {
			throw new IllegalStateException(
					"Falha ao serializar objeto do tipo "
							+ o.getClass().getName(),
					e);
		}
	}
}
