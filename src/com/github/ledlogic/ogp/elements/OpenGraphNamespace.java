package com.github.ledlogic.ogp.elements;

/**
 * @see https://developers.facebook.com/docs/payments/product/
 */
public enum OpenGraphNamespace {
	FB("fb: http://ogp.me/ns/fb"),
	PRODUCT("product: http://ogp.me/ns/product#"),
	OG("og: http://ogp.me/ns# ");
	
	private final String url;

	private OpenGraphNamespace(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}