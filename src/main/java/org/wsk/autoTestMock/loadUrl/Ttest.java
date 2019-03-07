package org.wsk.autoTestMock.loadUrl;

public class Ttest {

	public static void main(String[] args) {
		Ttest ttest = new Ttest();
		RealUrl url = new RealUrl();
		String string = url.getUrl();
		System.out.println(string);
	}

}
