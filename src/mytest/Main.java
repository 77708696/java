package mytest;
import hn.common.*;

import java.util.*;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
public class Main {
	private static final Logger LOGGER = Logger.getLogger(Main.class);
	public static void main(String[] args) {
		LOGGER.info("===============================================");
        LOGGER.info(" is ready to startup ...");
        LOGGER.debug("aaaaaaaaaaaaa");
        Properties properties = function.getPropertie(
        		System.getProperty("user.dir") + "/config.properties");
      //  for(Map.Entry<String, String> entry : properties.entrySet())
        Properties t = new Properties();
        t.put("test1", "huang");
        properties.putAll(t);
        
        for(Entry<Object, Object> entry : properties.entrySet()){
        	System.out.println( entry.getKey() + ":" + entry.getValue());
        }
	}

}
