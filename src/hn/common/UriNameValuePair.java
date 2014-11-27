package hn.common;
import org.apache.http.NameValuePair;
public class UriNameValuePair implements NameValuePair {

	private String _nameString="";
	private String _valuesString = "";
	public UriNameValuePair(String name,String value){
		_nameString = name;
		_valuesString = value;
	}
	
	public String getName(){
		return _nameString;
	}
	public String getValue(){
		return _valuesString;
	}
}
