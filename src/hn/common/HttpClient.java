package hn.common;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClient {

	private Charset charset = Charset.forName("utf-8");
	private Map<String, File> files = new HashMap<String, File>();
	private Map<String, String> headers = new HashMap<String, String>();
	private String _url="";
	private List<NameValuePair> _params = new ArrayList<NameValuePair>();
	public HttpClient(String url){
		_url = url;
	}
	public HttpClient SetUrl(String url){
		_url = url;
		return this;
	}
	public HttpClient SetChar(Charset charset){
		this.charset = charset;
		return this;
	}
	public HttpClient SetParams(List<NameValuePair> params){
		_params = params;
		return this;
	}
	public List<NameValuePair> GetParams(){
		return _params;
	}
	public HttpClient SetHeader(String key,String value){
		headers.put(key, value);
		return this;
	}
	public HttpClient SetFile(String finename,File file){
		files.put(finename, file);
		return this;
	}
	public String DoGet() throws Exception{		
		URI uri = new URIBuilder(_url)
		.setParameters(_params)
        .build();		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(uri);
		for( String k : headers.keySet())
			httpget.addHeader(k, headers.get(k));
		
		String body="";
		try {
			CloseableHttpResponse response = null;
			try {
				response = httpclient.execute(httpget);
			} catch (IOException e1) {
				e1.printStackTrace();
			}		
		    HttpEntity entity = response.getEntity();
		  //System.out.println(  response.toString() );
		    if (entity != null) {
		        try {
		        	body = EntityUtils.toString(entity);
		        }catch(Exception ex)
		        {
		        	
		        }finally {
		        	try {
						response.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
		        }
		    }
		} finally {
		    
		}
		
		return body;
	}
	
	public String DoPost() throws Exception {
		
		MultipartEntity reqEntity = new MultipartEntity(); 
		for(String k : files.keySet())
			reqEntity.addPart(k, new FileBody(files.get(k)));
		for( NameValuePair nv  :_params)
			reqEntity.addPart(nv.getName(), new StringBody(nv.getValue(),this.charset));
		HttpPost httppost = new HttpPost(_url);
		httppost.setEntity(reqEntity);
		for( String k : headers.keySet())
			httppost.addHeader(k, headers.get(k));
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		response = httpclient.execute(httppost);
		HttpEntity enHttpEntity = response.getEntity();
		return EntityUtils.toString(enHttpEntity);
	}
}
