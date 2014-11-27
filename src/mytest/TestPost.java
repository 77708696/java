package mytest;
import hn.common.*;

import org.apache.http.NameValuePair;

import java.io.File;
import java.util.*;
public class TestPost implements Runnable {

	public void run() {
		try{
			HttpClient hcClient = new HttpClient("http://localhost/web/app_dev.php/document");	
			for(int i=0;i<30;i++){
				System.out.println("===========" + Thread.currentThread().getName() + "");
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new UriNameValuePair("name",new String( new String("11测试文件上传").getBytes() , "utf8") ));
				System.out.println(hcClient.SetFile("meta", new File("d:\\1.jpg")).SetParams(params).SetHeader("accesstoken", "aaaaa").DoPost());
				
			}
		}catch(Exception ex)
		{
			
		}
	}
	public static void main(String[] args) throws Exception {
		
		TestPost tpPost = new TestPost();
		new Thread(tpPost,"1号线程").start();
		
		postContact();
		
	}
	
	
	public static void postContact() {
		
		System.out.println("===========创建联系人==========");
		try{
			HttpClient hcClient = new HttpClient("http://localhost/web/app_dev.php/contact");	
			for(int i=0;i<30;i++){
				
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add( new UriNameValuePair("contact", "aaa" ) );
				params.add( new UriNameValuePair("self","true"));
				hcClient.SetParams(params);
				hcClient.SetHeader("accesstoken", "aaaaa");
				System.out.println(hcClient.DoPost());
				
			}
		}catch(Exception ex)
		{
			
		}
	}
	

}
