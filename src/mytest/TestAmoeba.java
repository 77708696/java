package mytest;


import java.sql.ResultSet;

import hn.common.*;
public class TestAmoeba extends Thread {
	private DbHelp db ;//DbHelp.getInstance();
	private static int sum = 100;
	private int thread_id=0;
	private String name="";
	public TestAmoeba(int thread_id){
		this.thread_id = thread_id; 
	}
	
	public void run() {
		   db = new DbHelp();
		   db.ReSet("jdbc:mysql://192.168.30.104:4040/testdb", "root", "mysql");
		   String sql="select * from tb1 where id>0 order by rand() limit 1";
	        ResultSet rs ;
	        String _nameString = "";
	        try{
	        for(int i=0;i<sum;i++){
	        	Thread.sleep(10);
	        	_nameString = "Thread_" + this.thread_id;
	        	sql = "insert into tb1 (name) values ('" + _nameString+"')";
	        	//db.execute(sql);
	        	//System.out.println(sql);
	        	
	        	sql="select * from tb1 where id>"+this.thread_id+" and "+i+"="+i+" order by rand() limit 1";
	        	rs = db.query(sql);
	            rs.next();
	            System.out.println(rs.getString("id") + "___" + this.thread_id);
	        }
	        }catch(Exception ex){
	        	ex.printStackTrace();
	        	System.out.println(ex.getMessage());
	        }
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
        
       
        System.out.println("===========randon read" + sum + " number database====================");
        for(int i=10;i<150;i++){
        	TestAmoeba testAmoeba = new TestAmoeba(i);
        	testAmoeba.start();
        }
       
        
	}

}
