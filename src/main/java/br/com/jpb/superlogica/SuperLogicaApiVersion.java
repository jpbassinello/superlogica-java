package br.com.jpb.superlogica;

public enum SuperLogicaApiVersion {

	V2("https://api.superlogica.net/v2");

	private final String url;

	private SuperLogicaApiVersion(String url) {
		this.url = url;
	}

	public String getFullUrl(String endpoint) {
		if (endpoint == null) {
			return url;
		}
		String ep = endpoint.startsWith("/") ? endpoint : "/" + endpoint;
		return url + ep;
	}

}