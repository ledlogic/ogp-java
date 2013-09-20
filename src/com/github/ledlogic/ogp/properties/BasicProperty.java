package com.github.ledlogic.ogp.properties;

/**
 * @see https://developers.facebook.com/docs/opengraph/music/
 */

public enum BasicProperty implements PropertyInterface {
	AUDIO("og:audio", true),
	AUDIO_SECURE_URL("og:audio:secure_url"),
	AUDIO_TYPE("og:audio:type"),
	DESCRIPTION("og:description"),
	DETERMINER("og:determiner"),
	IMAGE("og:image", true),
	IMAGE_URL("og:image:url"),
	IMAGE_SECURE_URL("og:image:secure_url"),
	IMAGE_TYPE("og:image:type"),
	IMAGE_WIDTH("og:image:width"),
	IMAGE_HEIGHT("og:image:height"),
	LOCALE("og:locale"),
	LOCALE_ALTERNATE("og:locale:alternate"),
	RESTRICTIONS("og:restrictions"),
	RESTRICTIONS_COUNTRY("og:restrictions:country"),
	RESTRICTIONS_AGE("og:restrictions:age"),
	RESTRICTIONS_CONTENT("og:restrictions:content"),
	SEE_ALSO("og:see_also", true), // array
	SITE_NAME("og:site_name"),
	TITLE("og:title"),
	TYPE("og:type"),
	UPDATED_TIME("og:updated_time"),
	URL("og:url"),
	VIDEO("og:video", true),
	VIDEO_URL("og:video"),
	VIDEO_SECURE_URL("og:video:secure_url"),
	VIDEO_TYPE("og:video:type"),
	VIDEO_WIDTH("og:video:width"),
	VIDEO_HEIGHT("og:video:height");
	
	boolean array;
	String property;
	
	public String getProperty() {
		return property;
	}

	private BasicProperty(String property) {
		this.property = property;
		this.array = false;
	}
	
	private BasicProperty(String property, boolean array) {
		this.property = property;
		this.array = array;
	}

	@Override
	public boolean isArray() {
		return false;
	}
}