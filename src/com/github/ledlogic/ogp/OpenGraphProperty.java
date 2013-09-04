package com.github.ledlogic.ogp;

/**
 * @see http://ogp.me/
 */
public enum OpenGraphProperty {
	IMAGE("og:image"),
	TITLE("og:title"),
	TYPE("og:type"),
	URL("og:url"),
	
	AUDIO("og:audio"),
	DESCRIPTION("og:description"),
	DETERMINER("og:determiner"),
	LOCALE("og:locale"),
	LOCALE_ALTERNATE("og:locale:alternate"),
	SITE_NAME("og:site_name"),
	VIDEO("og:video"),

	IMAGE_URL("og:image:url"),
	IMAGE_SECURE_URL("og:image:secure_url"),
	IMAGE_TYPE("og:image:type"),
	IMAGE_WIDTH("og:image:width"),
	IMAGE_HEIGHT("og:image:height"),
	
	VIDEO_URL("og:video"),
	VIDEO_SECURE_URL("og:video:secure_url"),
	VIDEO_TYPE("og:video:type"),
	VIDEO_WIDTH("og:video:width"),
	VIDEO_HEIGHT("og:video:height"),

	AUDIO_SECURE_URL("og:audio:secure_url"),
	AUDIO_TYPE("og:audio:type");
	
	String property;
	
	public String getProperty() {
		return property;
	}

	private OpenGraphProperty(String property) {
		this.property = property;
	}
}