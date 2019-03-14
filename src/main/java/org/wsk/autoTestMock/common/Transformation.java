package org.wsk.autoTestMock.common;

import java.util.LinkedList;

public class Transformation {
	
	public static void main(String[] args) {
		
		User user = new User();
		User user2 = new User();
		LinkedList<User> list = new LinkedList<User>();
		list.add(user);
		list.add(user2);
		Object[][] obj = {
				{"1", "2"},
				{"3", "4"}
				
		};
	}
	
}
