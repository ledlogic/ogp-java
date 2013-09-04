package com.github.ledlogic.ogp;

import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

public class OpenGraphMeta extends Element {

	public OpenGraphMeta(String property, String content) {
		super(Tag.valueOf("meta"), "");
		attr("property", property);
		attr("content", content);
	}

	public OpenGraphMeta(Element element) {
		super(Tag.valueOf("meta"), "");
		attr("property", element.attr("property"));
		attr("content", element.attr("content"));
	}

	public String getProperty() {
		return attr("property");
	}
	
	public String getContent() {
		return attr("content");
	}
	
}
