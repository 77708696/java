package hn.common;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class function {

	/**
	 * º”‘ÿPropertie ≈‰÷√
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
}
