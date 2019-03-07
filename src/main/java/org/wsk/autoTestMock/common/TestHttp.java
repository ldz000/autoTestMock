package org.wsk.autoTestMock.common;

import java.util.HashMap;

public class TestHttp {
	public static void main(String[] args) {
		HttpClientTool tool = new HttpClientTool();
		HashMap<String, String> map = new HashMap<>();
		map.put("name", "liuwf");
		map.put("age", "23");
		String str = tool.doPost("http://httpbin.org/post",map , "UTF-8");
	}
}
