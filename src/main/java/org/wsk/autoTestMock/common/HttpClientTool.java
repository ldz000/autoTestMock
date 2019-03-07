package org.wsk.autoTestMock.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class HttpClientTool {
	private static Logger logger = Logger.getLogger(HttpClientTool.class);
	private static final CloseableHttpClient httpClient;
	private static final String CHARSET = "UTF-8";
	static {
		RequestConfig config = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(15000).build();
		httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();

	}

	// static {
	// HttpClientTool.createSSLClientDefault();
	// }

	/**
	 * get请求
	 * 
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */

	public static String doGet(String url, Map<String, String> params) {
		URI uriWithParams = null;
		String result = null;
		CloseableHttpResponse response = null;
		try {
			if (url == "" || url == null) {
				return null;
			}

			if (params == null || params.isEmpty()) {
				uriWithParams = new URIBuilder(url).build();
			} else {
				ArrayList<NameValuePair> list = new ArrayList<NameValuePair>(params.size());
				for (Map.Entry<String, String> entry : params.entrySet()) {
					list.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
				}
				uriWithParams = new URIBuilder(url).addParameters(list).build();
			}
			HttpGet get = new HttpGet(uriWithParams);
			response = httpClient.execute(get);
			System.out.println(get.getURI());
			if (response.getStatusLine().getStatusCode() == 200) {
				if (response.getEntity() != null) {

					result = EntityUtils.toString(response.getEntity(), CHARSET);
					response.close();
				}

			}
		} catch (URISyntaxException | IOException ex) {
			logger.error(ex);
			throw new RuntimeException(ex.getMessage());
		}
		return null;
	}

	/**
	 * 
	 * 
	 * 
	 * @param url
	 * @param params
	 * @param charset
	 * @return
	 */
	public static String doPost(String url, Map<String, String> params, String charset) {
		List<NameValuePair> pairs = null;
		CloseableHttpResponse response = null;
		if (url == null || url == "") {
			return null;
		}
		if (params != null && !params.isEmpty()) {
			pairs = new ArrayList<NameValuePair>(params.size());
			for (Map.Entry<String, String> entry : params.entrySet()) {
				if (entry.getValue() != null) {
					pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
				}
			}

		}
		HttpPost post = new HttpPost(url);
		try {
			String result = null;
			post.setEntity(new UrlEncodedFormEntity(pairs, CHARSET));
			response = httpClient.execute(post);
			if (response.getStatusLine().getStatusCode() != 200) {
				post.abort();
				throw new RuntimeException(
						"HttpClinet Error status code:" + response.getStatusLine().getReasonPhrase());
			}
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity, CHARSET);
			}
			EntityUtils.consume(entity);
			return result;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;
	}
	
	

}
