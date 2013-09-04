package com.github.ledlogic.ogp;

import org.junit.Assert;
import org.junit.Test;

public class OpenGraphElementsTest {

	@Test
	public void testGetHtml() {
		OpenGraphElements elements = new OpenGraphElements();
		String html = elements.getHtml();
		Assert.assertEquals("", html);
	}

}
