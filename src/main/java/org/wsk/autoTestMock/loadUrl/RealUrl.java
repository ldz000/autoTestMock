package org.wsk.autoTestMock.loadUrl;

import java.util.ResourceBundle;

public class RealUrl {
	
	static String getUrl(){
		ResourceBundle bundle = ResourceBundle.getBundle("url.application");
		String baseUrl = bundle.getString("testUrl");
		return baseUrl;
	}
}
