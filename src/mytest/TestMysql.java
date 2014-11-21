package mytest;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import hn.common.*;

public class TestMysql {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DbHelp dbHelp = DbHelp.getInstance();
		ResultSet rs = dbHelp.query("SELECT * FROM `account_basic`");
		while(rs.next()){			
			System.out.println(rs.getString("email") + "__" + rs.getInt("id"));
		}
		
		System.out.println("-------------´øÕ¼Î»·û-----------------");
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		//map.put(1, "hc@qq.com");
		map.put(1, 1);
		
		rs = dbHelp.query("SELECT * FROM `account_basic` WHERE secure_level=?",map);
		while(rs.next()){			
			System.out.println(rs.getString("email") + "__" + rs.getInt("id"));
			System.out.println(rs.getRow());
		}
		
		System.out.println("-------------test insert-----------------");
		
		String sql = "insert into trash (trash_id,user_id,document_id,type,deleted_time)"
				+ " VALUES ('q','q','qw','card',now())";
		
		System.out.println(dbHelp.execute(sql));
		sql = "insert into trash (trash_id,user_id,document_id,type,deleted_time)"
				+ " VALUES ('q',?,'qw','card',now())";
		
		map.clear();
		map.put(1, "user_iiiiddd");
		
		function.PrintMap(map);
		
		System.out.println(dbHelp.execute(sql,map));
		dbHelp.closeResultSet(rs);
		
	}

}
