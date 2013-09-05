package com.github.ledlogic.ogp;

/**
 * @see https://developers.facebook.com/docs/reference/opengraph/object-type/product/
 */
public enum ProductProperty {
	AVAILABILITY("product:availability"),
	BRAND("product:brand"),
	CATEGORY("product:category"),
	COLOR("product:color"),
	CONDITION("product:condition"),
	EAN("product:ean"),
	EXPIRATION_TIME("product:expiration_time"),
	ISBN("product:isbn"),
	MATERIAL("product:material"),
	MFR_PART_NO("product:mfr_part_no"),
	PATTERN("product:pattern"),
	PLURAL_TITLE("product:plural_title"),
	PRICE("product:price"),
	PRICE_AMOUNT("product:price:amount"),
	PRICE_CURRENCY("product:price:currency"),
	PRODUCT_LINK("product:product_link"),
	RETAILER("product:retailer"),
	RETAILER_TITLE("product:retailer_title"),
	RETAILER_PART_NO("product:retailer_part_no"),
	SHIPPING_COST("product:shipping_cost"),
	SHIPPING_COST_AMOUNT("product:shipping_cost:amount"),
	SHIPPING_COST_CURRENCY("product:shipping_cost:currency"),
	SHIPPING_WEIGHT("product:shipping_weight"),
	SHIPPING_WEIGHT_VALUE("product:weight:value"),
	SHIPPING_WEIGHT_UNITS("product:weight:units"),
	SIZE("product:size"),
	UPC("product:upc"),
	WEIGHT("product:weight"),
	WEIGHT_VALUE("product:weight:value"),
	WEIGHT_UNITS("product:weight:units");
	
	String property;
	
	public String getProperty() {
		return property;
	}

	private ProductProperty(String property) {
		this.property = property;
	}
}