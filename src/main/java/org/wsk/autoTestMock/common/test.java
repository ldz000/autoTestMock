package org.wsk.autoTestMock.common;

import java.util.HashMap;
import java.util.Map;

public class test {
	public static void main(String[] args) {
		
		HttpClientTool clientTool = new HttpClientTool();
		Map<String,String> map = new HashMap<String, String>();
		map.put("name", "liu");
		map.put("age", "24");
		String string = clientTool.doGet("http://www.baidu.com", map);
		
		System.out.println(string);
		
		
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("e", "1");
//		map.put("f", "2");
//		for (Map.Entry<String, String> str : map.entrySet()) {
////			String value = str.getValue();
////			System.out.println(value);
////			System.out.println(str.getKey()+value);
//			String key = str.getKey();
//			System.out.println(key);
//		}
	}
}