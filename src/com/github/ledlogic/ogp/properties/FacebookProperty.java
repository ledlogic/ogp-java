package com.github.ledlogic.ogp.properties;

/**
 * @see https://developers.facebook.com/docs/opengraph/music/
 * @see http://www.hyperarts.com/blog/tutorial-integrate-your-website-with-facebooks-open-graph-social-plugins/
 */
public enum FacebookProperty implements PropertyInterface {
	ADMINS("fb:admins"),
	APP_ID("fb:app_id"),
	PROFILE_ID("fb:profile_id ");

	String property;
	
	public String getProperty() {
		return property;
	}

	private FacebookProperty(String property) {
		this.property = property;
	}
	
	public boolean isArray() {
		return false;
	}
}