package org.wsk.autoTestMock.testcase;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.wsk.autoTestMock.loadurl.RealUrl;

public class TestUrl {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeMethod
	public void setUp() throws Exception {
	}

	@AfterMethod
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws URISyntaxException, UnsupportedEncodingException, MalformedURLException {
		List<NameValuePair> list = new LinkedList<>();
		BasicNameValuePair param1 = new BasicNameValuePair("name", "root");
		BasicNameValuePair param2 = new BasicNameValuePair("password", "123456");
		list.add(param1);
		list.add(param2);
		String url = RealUrl.getUrl("baseUrl");
		URIBuilder builder = new URIBuilder(url);
		builder.setParameters(list);
		System.out.println(builder.build());
	}
	@Test
	public void test2() throws MalformedURLException{
	}
}
