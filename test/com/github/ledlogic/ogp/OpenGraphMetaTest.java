package com.github.ledlogic.ogp;

import junit.framework.Assert;

import org.junit.Test;

public class OpenGraphMetaTest {

	@Test
	public void testOpenGraphMeta() {
		String property = "og:title";
		String content = "title";
		OpenGraphMeta m = new OpenGraphMeta(property, content);
		String html = m.outerHtml();
		Assert.assertEquals("<meta property=\"og:title\" content=\"title\" />", html);
		Assert.assertEquals(property, m.getProperty());
		Assert.assertEquals(content, m.getContent());
	}

}
