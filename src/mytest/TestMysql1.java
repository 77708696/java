package mytest;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import hn.common.*;
public class TestMysql1 {

    public static void main(String[] args) throws Exception {
        DbHelp dbHelp = DbHelp.getInstance();
        String sql = "insert into t (id,name)"
                + " VALUES (1,'aaa')";
        System.out.println(dbHelp.execute(sql));
        
    }

}
