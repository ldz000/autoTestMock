package org.wsk.autoTestMock.loadurl;

import java.util.ResourceBundle;

public class RealUrl {
	
	public static String getUrl(String path){
		ResourceBundle bundle = ResourceBundle.getBundle("url.application");
		String url = bundle.getString(path);
		return url;
	}
}
