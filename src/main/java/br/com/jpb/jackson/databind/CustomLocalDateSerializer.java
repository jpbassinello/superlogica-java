package br.com.jpb.jackson.databind;

import java.io.IOException;
import java.time.ZoneId;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import br.com.jpb.superlogica.Constants;

public class CustomLocalDateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date date, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider)
					throws IOException, JsonProcessingException {
		if (date == null) {
			jsonGenerator.writeNull();
			return;
		}
		String dateString = Constants.DATE_FORMATTER
				.format(date.toInstant().atZone(ZoneId.systemDefault()));
		jsonGenerator.writeString(dateString);
	}
}