package com.github.ledlogic.ogp;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;;

public class OpenGraphElements extends Elements {

	public OpenGraphElements() {
		super();
	}

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
	
}
