package org.wsk.autoTestMock.loadUrl;

import java.util.Locale;
import java.util.ResourceBundle;

import org.testng.annotations.Test;

public class RealUrl {
	
	static String getUrl(){
		ResourceBundle bundle = ResourceBundle.getBundle("url.application");
		String baseUrl = bundle.getString("testUrl");
		System.out.println(baseUrl);
		return null;
	}
	@Test
	public void test1(){
		String url = this.getUrl();
		System.out.println(url);
	}
	
	
}
