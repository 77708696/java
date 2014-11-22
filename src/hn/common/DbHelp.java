package hn.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

public class DbHelp {

	private static DbHelp _dbDbHelp = null;
	private Connection dbConnection=null; 
	public static DbHelp getInstance(){
		if( _dbDbHelp==null)
			_dbDbHelp = new DbHelp();
		return _dbDbHelp;
	}
	private DbHelp(){
		 init();
	}
	
	private void  init() {
        Properties props = new Properties();
        FileInputStream fis = null;
        Connection con = null;
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
            props.load(fis);            
            //connection mysql
            con = getConnection(props.getProperty("DB_URL"), props.getProperty("DB_USERNAME"), props.getProperty("DB_PASSWORD"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dbConnection = con;
    }
	private Connection getConnection(String url,String username,String password){
	    Connection con = null;
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            //connection mysql
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
	}
	public void ReSet(String url,String username,String password){
	    dbConnection = getConnection(url,username,password);
	}
	
	public int execute(String sql) throws Exception {
		PreparedStatement ps = null;
		ps = dbConnection.prepareStatement(sql);        
        return ps.executeUpdate();
	}
	public int execute(String sql,Map<Object, Object> map) throws Exception {		
		PreparedStatement ps = null;
		ps = dbConnection.prepareStatement(sql);
		bindParam(ps, map);
        return ps.executeUpdate();
	}
	public ResultSet query(String sql) throws Exception{
		PreparedStatement ps = null;
        ResultSet rs = null;        
        ps = dbConnection.prepareStatement(sql);        
        rs = ps.executeQuery();
        
        return rs;
	}
	public ResultSet query(String sql,Map<Object, Object> map) throws Exception{
		PreparedStatement ps = null;
        ResultSet rs = null;        
        ps = dbConnection.prepareStatement(sql);
        bindParam(ps, map);
        rs = ps.executeQuery();
        return rs;
	}
	private void bindParam(PreparedStatement ps,Map<Object, Object> map) throws Exception{
		for(Object key : map.keySet()){
			if(map.get(key) instanceof Integer)
				ps.setInt((int)key, (int) map.get(key));
			else
				ps.setString((int)key, (String) map.get(key));
		}
		
	}
	
	// �ر�Connection
    public void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
                con = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            con = null;
        }
    }
	// �ر�ResultSet
    public void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
                rs = null;
            } catch (SQLException e) {
                //e.printStackTrace();
            }
        }
    }
	
}
