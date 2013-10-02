package com.github.ledlogic.ogp;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.github.ledlogic.ogp.elements.OpenGraphElements;
import com.github.ledlogic.ogp.parsers.OpenGraphParser;
import com.github.ledlogic.ogp.properties.BasicProperty;

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
		Assert.assertEquals("The Rock", elements.getMetaContent(BasicProperty.TITLE.getProperty()));
		Assert.assertEquals("video.movie", elements.getMetaContent(BasicProperty.TYPE.getProperty()));
		Assert.assertEquals("http://www.imdb.com/title/tt0117500/", elements.getMetaContent(BasicProperty.URL.getProperty()));
		Assert.assertEquals("http://ia.media-imdb.com/images/rock.jpg", elements.getMetaContent(BasicProperty.IMAGE.getProperty()));
		String outer = elements.outerHtml();
		Assert.assertTrue(StringUtils.isNotBlank(outer));
		
		String fn2 = "/html/test-0002.html";
		URL url2 = this.getClass().getResource(fn2);
		File file2 = new File(url2.getFile());
		String html2 = FileUtils.readFileToString(file2, "UTF-8");
		Assert.assertTrue(StringUtils.isNotBlank(html2));
		Assert.assertEquals(html2, outer);
	}
	
	@Test
	public void testParseMultipleImages5() throws IOException {
		String fn5 = "/html/test-0005.html";
		URL url5 = this.getClass().getResource(fn5);
		File file5 = new File(url5.getFile());
		String html5 = FileUtils.readFileToString(file5, "UTF-8");
		OpenGraphParser ogp = new OpenGraphParser();
		OpenGraphElements elements = ogp.parseHtml(html5);
		Assert.assertEquals(6, elements.size());
		Assert.assertEquals("http://example.com/rock.jpg", elements.getMetaContent(BasicProperty.IMAGE.getProperty()));
		Assert.assertEquals("300", elements.getMetaContent(BasicProperty.IMAGE_WIDTH.getProperty()));
		Assert.assertEquals("300", elements.getMetaContent(BasicProperty.IMAGE_HEIGHT.getProperty()));
		Assert.assertEquals("300", elements.getMetaContent(BasicProperty.IMAGE_HEIGHT.getProperty(), 0));
		Assert.assertEquals("300", elements.getMetaContent(BasicProperty.IMAGE_HEIGHT.getProperty(), 1));
		
		Assert.assertEquals("http://example.com/rock2.jpg", elements.getMetaContent(BasicProperty.IMAGE.getProperty(), 1));
		Assert.assertEquals("http://example.com/rock3.jpg", elements.getMetaContent(BasicProperty.IMAGE.getProperty(), 2));
		Assert.assertEquals("1000", elements.getMetaContent(BasicProperty.IMAGE_HEIGHT.getProperty(), 2));
		
		String outer = elements.outerHtml();
		Assert.assertTrue(StringUtils.isNotBlank(outer));
	}
	
	@Test
	public void testParseMultipleImages6() throws IOException {
		String fn5 = "/html/test-0006.html";
		URL url5 = this.getClass().getResource(fn5);
		File file5 = new File(url5.getFile());
		String html5 = FileUtils.readFileToString(file5, "UTF-8");
		OpenGraphParser ogp = new OpenGraphParser();
		OpenGraphElements elements = ogp.parseHtml(html5);
		Assert.assertEquals(9, elements.size());
		Assert.assertEquals("http://example.com/rock.jpg", elements.getMetaContent(BasicProperty.IMAGE.getProperty()));
		Assert.assertEquals("300", elements.getMetaContent(BasicProperty.IMAGE_WIDTH.getProperty()));
		Assert.assertEquals("300", elements.getMetaContent(BasicProperty.IMAGE_HEIGHT.getProperty()));
		Assert.assertEquals("300", elements.getMetaContent(BasicProperty.IMAGE_HEIGHT.getProperty(), 0));
		Assert.assertEquals("300", elements.getMetaContent(BasicProperty.IMAGE_HEIGHT.getProperty(), 1));
		
		Assert.assertEquals("http://example.com/rock2.jpg", elements.getMetaContent(BasicProperty.IMAGE.getProperty(), 1));
		Assert.assertEquals("http://example.com/rock3.jpg", elements.getMetaContent(BasicProperty.IMAGE.getProperty(), 2));
		Assert.assertEquals("1000", elements.getMetaContent(BasicProperty.IMAGE_HEIGHT.getProperty(), 2));

		Assert.assertEquals("http://example.com/rock4.jpg", elements.getMetaContent(BasicProperty.IMAGE.getProperty(), 3));
		Assert.assertEquals("1000", elements.getMetaContent(BasicProperty.IMAGE_HEIGHT.getProperty(), 3));
		Assert.assertEquals("http://example.com/rock5.jpg", elements.getMetaContent(BasicProperty.IMAGE.getProperty(), 4));
		Assert.assertEquals("2000", elements.getMetaContent(BasicProperty.IMAGE_HEIGHT.getProperty(), 4));

		String outer = elements.outerHtml();
		Assert.assertTrue(StringUtils.isNotBlank(outer));
	}
	
}
