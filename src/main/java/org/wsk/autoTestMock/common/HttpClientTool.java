package org.wsk.autoTestMock.common;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class HttpClientTool {
	private static Logger logger = Logger.getLogger(HttpClientTool.class);
	private static final CloseableHttpClient httpClient;
	private static final String CHARSET = "UTF-8";
	private static BasicCookieStore cookieStore = null;
	static {
		cookieStore = new BasicCookieStore();
		RequestConfig config = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(15000).build();
		httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).setDefaultCookieStore(cookieStore).build();

	}

	/**
	 * get请求
	 * 
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */

	public static String doGet(String url, Map<String, String> params) {
		System.out.println("doget方法被调用了");
		URI uriWithParams = null;
		String result = null;
		CloseableHttpResponse response = null;
		System.out.println("111111111111111111111111111111111111111111111111");
		try {
			if (url == "" || url == null) {
				return null;
			}
			if (params == null || params.isEmpty()) {
				uriWithParams = new URIBuilder(url).build();
				System.out.println("no params bulid url"+ url);
			} else {
				ArrayList<NameValuePair> list = new ArrayList<NameValuePair>(params.size());
				for (Map.Entry<String, String> entry : params.entrySet()) {
					list.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
				}
				uriWithParams = new URIBuilder(url).addParameters(list).build();
			}
			HttpGet get = new HttpGet(uriWithParams);
			response = httpClient.execute(get);
			List<Cookie> list = cookieStore.getCookies();
			System.out.println("cookie的长度为"+list.size()+"---------------------------------------------------------------------------------");
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
	
	/**
	 * 
	 * 
	 */

	public static HttpResponse doPostWithFile(String url, Map<String, String> params,List<File> files, Map<String, String> headers, String encode){
		HttpPost post = new HttpPost(url);
		CloseableHttpResponse response = null;
		if(headers!=null){
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				post.setHeader(entry.getKey(), entry.getValue());
			}
		}
		 MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
		 multipartEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);  
		 multipartEntityBuilder.setCharset(Charset.forName(encode)); 
		 ContentType contentType = ContentType.create("text/plain",Charset.forName(encode));//解决中文乱码  
        if (params != null && params.size() > 0) {  
            Set<String> keySet = params.keySet();  
            for (String key : keySet) {  
            	multipartEntityBuilder.addTextBody(key, params.get(key),contentType);  
            }  
        }  
        //二进制参数  
        if (files != null && files.size() > 0) {  
            for (File file : files) {  
            	multipartEntityBuilder.addBinaryBody("file", file);  
            }  
        }  
        post.setEntity(multipartEntityBuilder.build());
        try {
			CloseableHttpResponse respones = httpClient.execute(post);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
        
        try {
			httpClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}
	
	
	
	
	/**
	 * 
	 * 
	 */
	public static HttpResponse doDelete(String url, Map<String, String> headers, String encode){
		HttpDelete delete = new HttpDelete();
		HttpResponse response = null;
		if(headers!=null&&headers.size()>0){
			for (Entry<String, String> entry : headers.entrySet()) {
				delete.setHeader(entry.getKey(),entry.getValue());
			}
		}
		try {
			response = httpClient.execute(delete);
			String content = EntityUtils.toString(response.getEntity(), CHARSET);
			return response;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
