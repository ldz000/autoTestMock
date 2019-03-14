package org.wsk.autoTestMock.testcase;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
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
		System.out.println(url);
		URIBuilder builder = new URIBuilder(url);
		builder.setParameters(list);
		System.out.println(builder.build());
	}
	
	@Test
	public void test2() throws ParseException, UnsupportedEncodingException, IOException, URISyntaxException{
		
		LinkedList<NameValuePair> list = new LinkedList<NameValuePair>();
		BasicNameValuePair pair = new BasicNameValuePair("name", "lww");
		BasicNameValuePair pair2 = new BasicNameValuePair("age", "23");
		list.add(pair);
		list.add(pair2);
		String str = EntityUtils.toString(new UrlEncodedFormEntity(list, "UTF-8"));
		String url = RealUrl.getUrl("baseUrl");
//		URIBuilder builder = new URIBuilder(url);
		System.out.println("请求的get方法为"+url+str);
		
		
	}
	@Test
	public void test3() throws URISyntaxException{
		String url = RealUrl.getUrl("baseUrl");
		String url2 = "http://127.0.0.1:8888/demo";
		URIBuilder builder = new URIBuilder(url);
		System.out.println(builder);
	}
}
