package org.wsk.autoTestMock.testcase;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wsk.autoTestMock.common.HttpClientTool;
import org.wsk.autoTestMock.loadurl.RealUrl;

public class LoginTest {

	String url = null;
	@BeforeClass
	public void setUpClass() {
		url = RealUrl.getUrl("baseUrl");
	}

	@Test
	public void LoginTest() {
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("name", "lww");
		map.put("age", "34");
		String result = HttpClientTool.doGet(url, map);
		
	}
}
