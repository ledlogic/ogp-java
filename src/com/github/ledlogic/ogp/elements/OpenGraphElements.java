package com.github.ledlogic.ogp.elements;

import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.github.ledlogic.ogp.properties.PropertyInterface;

public class OpenGraphElements extends Elements {

	public OpenGraphElements() {
		super();
	}

	/**
	 * Returns the first meta with this property.
	 * @param property
	 * @return
	 */
	public OpenGraphMeta getMeta(String property) {
		for (Element element:this) {
			if (property.equals(element.attr("property"))) {
				return (OpenGraphMeta)element;
			}
		}
		return null;
	}
	
	public String getMetaContent(String property) {
		OpenGraphMeta meta = getMeta(property);
		if (meta != null) {
			return meta.attr("content");
		}
		return null;
	}
	
	public String getHtml() {
		return this.outerHtml();
	}
	
	public void addMeta(PropertyInterface property, String content) {
		if (property != null && StringUtils.isNotBlank(content)) {
			addMeta(property.getProperty(), content);
		}
	}
	
	public void addMeta(String property, String content) {
		if (StringUtils.isNotBlank(property) && StringUtils.isNotBlank(content)) {
			OpenGraphMeta meta = new OpenGraphMeta(property, content);
			this.add(meta);
		}
	}
	
}
