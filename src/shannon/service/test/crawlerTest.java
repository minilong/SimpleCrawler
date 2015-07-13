package shannon.service.test;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.xml.stream.XMLStreamException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import shannon.service.Crawler;

public class crawlerTest {
	private Crawler crawler;
	private URL url;
	
	
	@Before
	public void initial() throws XMLStreamException, IOException{
		url = new URL("http://www.court.gov.cn/zgcpwsw/sx/sxsxzszjrmfy/pgxrmfy/xs/201507/t20150712_9465945.htm");
		crawler = new Crawler(url);
	}
	
	@Test
	public void testCrawl(){
		char[] bts = crawler.crawl();
		Scanner scan = new Scanner(new CharArrayReader(bts));
		Assert.assertNotNull(scan.nextLine());
		System.out.println(bts);
	}
	
}
