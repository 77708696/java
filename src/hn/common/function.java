package hn.common;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class function {

	/**
	 * ����Propertie ����
	 * @param file
	 * @return
	 */
	public static Properties getPropertie(String file){
		try{
			InputStream inStream = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(inStream);
			return properties;
		}catch(Exception ex){
			
		}
		return null;
	}
	
	public static void PrintMap(Map<Object, Object> map){
		for(Object key : map.keySet())
			System.out.println(key + ":" + map.get(key));
	
	}
}
