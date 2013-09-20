package com.github.ledlogic.ogp;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import com.github.ledlogic.ogp.elements.OpenGraphElements;
import com.github.ledlogic.ogp.properties.BasicProperty;
import com.github.ledlogic.ogp.properties.FacebookProperty;

public class OpenGraphElementsTest {

	@Test
	public void testGetHtml() {
		OpenGraphElements elements = new OpenGraphElements();
		String html = elements.getHtml();
		Assert.assertEquals("", html);
	}
	
	// @see http://www.hyperarts.com/blog/tutorial-integrate-your-website-with-facebooks-open-graph-social-plugins/
	@Test
	public void testGetHtmlSample() throws IOException {
		String fn3 = "/html/test-0003.html";
		URL url3 = this.getClass().getResource(fn3);
		File file3 = new File(url3.getFile());
		String html3 = FileUtils.readFileToString(file3, "UTF-8");
		
		OpenGraphElements elements = new OpenGraphElements();
		elements.addMeta(FacebookProperty.APP_ID, "YOUR-APP-ID");
		elements.addMeta(FacebookProperty.ADMINS, "USER_ID,USER_ID");
		elements.addMeta(BasicProperty.TITLE, "Page Title");
		elements.addMeta(BasicProperty.TYPE, "TYPE");
		elements.addMeta(BasicProperty.URL, "http://www.mydomain.com/page-url");
		elements.addMeta(BasicProperty.IMAGE, "http://URL-TO-IMAGE");
		elements.addMeta(BasicProperty.DESCRIPTION, "Description of page content");
		
		String html = elements.getHtml();
		Assert.assertEquals(html3, html);
	}

	// @see http://ogp.me
	@Test
	public void testGetHtml4() throws IOException {
		String fn4 = "/html/test-0004.html";
		URL url4 = this.getClass().getResource(fn4);
		File file4 = new File(url4.getFile());
		String html4 = FileUtils.readFileToString(file4, "UTF-8");
		
		OpenGraphElements elements = new OpenGraphElements();
		elements.addMeta(BasicProperty.TITLE, "Open Graph protocol");
		elements.addMeta(BasicProperty.TYPE, "website");
		elements.addMeta(BasicProperty.URL, "http://ogp.me/");
		elements.addMeta(BasicProperty.IMAGE, "http://ogp.me/logo.png");
		elements.addMeta(BasicProperty.IMAGE_TYPE, "image/png");
		elements.addMeta(BasicProperty.IMAGE_WIDTH, "300");
		elements.addMeta(BasicProperty.IMAGE_HEIGHT, "300");
		elements.addMeta(BasicProperty.DESCRIPTION, "The Open Graph protocol enables any web page to become a rich object in a social graph.");
		elements.addMeta(FacebookProperty.APP_ID, "115190258555800");
		
		String html = elements.getHtml();
		Assert.assertEquals(html4, html);
	}
}
