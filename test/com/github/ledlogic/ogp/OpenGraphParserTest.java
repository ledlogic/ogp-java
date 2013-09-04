package com.github.ledlogic.ogp;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class OpenGraphParserTest {

	@Test
	public void testParseHtml() throws IOException {
		String fn1 = "/html/test-0001.html";
		URL url1 = this.getClass().getResource(fn1);
		File file1 = new File(url1.getFile());
		String html1 = FileUtils.readFileToString(file1, "UTF-8");
		OpenGraphParser ogp = new OpenGraphParser();
		OpenGraphElements elements = ogp.parseHtml(html1);
		Assert.assertEquals(4, elements.size());
		Assert.assertEquals("The Rock", elements.getMetaContent(OpenGraphProperty.TITLE.getProperty()));
		Assert.assertEquals("video.movie", elements.getMetaContent(OpenGraphProperty.TYPE.getProperty()));
		Assert.assertEquals("http://www.imdb.com/title/tt0117500/", elements.getMetaContent(OpenGraphProperty.URL.getProperty()));
		Assert.assertEquals("http://ia.media-imdb.com/images/rock.jpg", elements.getMetaContent(OpenGraphProperty.IMAGE.getProperty()));
		String outer = elements.outerHtml();
		Assert.assertTrue(StringUtils.isNotBlank(outer));
		
		String fn2 = "/html/test-0002.html";
		URL url2 = this.getClass().getResource(fn2);
		File file2 = new File(url2.getFile());
		String html2 = FileUtils.readFileToString(file2, "UTF-8");
		Assert.assertTrue(StringUtils.isNotBlank(html2));
		Assert.assertEquals(html2, outer);
	}

}
