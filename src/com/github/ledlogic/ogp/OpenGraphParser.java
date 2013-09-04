package com.github.ledlogic.ogp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class OpenGraphParser {
	
	public OpenGraphParser() {
	}
	
	public OpenGraphElements parseHtml(String html) {
		OpenGraphElements ret = new OpenGraphElements();
		Document doc = Jsoup.parse(html, "");
		Elements meta = doc.select("meta[property^=og:]");
		for (Element element: meta) {
			OpenGraphMeta openGraphMeta = new OpenGraphMeta(element);
			ret.add(openGraphMeta);
		}
		return ret;
	}
	
}
