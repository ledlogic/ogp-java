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
	
	/**
	 * @param property
	 * @param index - the zero-based incidence
	 * @return
	 */
	private OpenGraphMeta getMeta(String property, int index) {
		OpenGraphMeta ret = null;
		String parent = null;
		String[] s = property.split(":");
		if (s.length > 2) {
			parent = s[0] + ":" + s[1];
		}
		int parentIndex = -1;
		int elementIndex = -1;
		for (Element element:this) {
			String elementProperty = element.attr("property");
			if (parent != null && parent.equals(elementProperty)) {
				parentIndex++;
				if (elementIndex < parentIndex) {
					elementIndex = parentIndex;
				}
			}
			if (property.equals(elementProperty)) {
				elementIndex++;
				ret = (OpenGraphMeta)element;
				if (parentIndex == index || elementIndex == index) {
					return ret;
				}
			}
		}
		return ret;
	}
	
	public String getMetaContent(String property) {
		OpenGraphMeta meta = getMeta(property);
		if (meta != null) {
			return meta.attr("content");
		}
		return null;
	}
	
	public String getMetaContent(String property, int index) {
		OpenGraphMeta meta = getMeta(property, index);
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
