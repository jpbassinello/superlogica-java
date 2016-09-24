package br.com.jpb.jackson.databind;

import br.com.jpb.superlogica.Constants;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.node.TextNode;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CustomLocalDateDeserializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {
		ObjectCodec oc = jsonParser.getCodec();
		TextNode node = (TextNode) oc.readTree(jsonParser);
		String dateString = node.getTextValue();

		if (dateString == null || dateString.isEmpty()) {
			return null;
		}

		return Date.from(LocalDate.from(Constants.DATE_FORMATTER.parse(dateString)).atStartOfDay(ZoneId
				.systemDefault())
				.toInstant());
	}

}