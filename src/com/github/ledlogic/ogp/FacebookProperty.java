package com.github.ledlogic.ogp;

/**
 * @see https://developers.facebook.com/docs/opengraph/music/
 */
public enum FacebookProperty {
	ADMINS("fb:admins"),
	APP_ID("fb:app_id"),
	PROFILE_ID("fb:profile_id ");
	
	boolean array;
	String property;
	
	public String getProperty() {
		return property;
	}

	private FacebookProperty(String property) {
		this.property = property;
		this.array = false;
	}
}