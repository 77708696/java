package mytest;

import hn.common.*;
public class TestCobar {

    public static void main(String[] args) throws Exception {
        /**
         * http://blog.csdn.net/wxwzy738/article/details/17265577  Cobar java 客户端测试
         * 其次，我们也需要注意Cobar的功能约束：
         * https://github.com/alibaba/cobar
https://github.com/alibaba/cobar/wiki/常见问
1) 不支持跨库情况下的join、分页、排序、子查询操作。
2) SET语句执行会被忽略，事务和字符集设置除外。
3) 分库情况下，insert语句必须包含拆分字段列名。
4) 分库情况下，update语句不能更新拆分字段的值。
5) 不支持SAVEPOINT操作。
6) 暂时只支持MySQL数据节点。
7) 使用JDBC时，不支持rewriteBatchedStatements=true参数设置(默认为false)。
8) 使用JDBC时，不支持useServerPrepStmts=true参数设置(默认为false)。
9) 使用JDBC时，BLOB, BINARY, VARBINARY字段不能使用setBlob()或setBinaryStream()方法设置参数。
         */
        // TODO Auto-generated method stub
        DbHelp db = DbHelp.getInstance();
        db.ReSet("jdbc:mysql://localhost:8076/dbtest", "root", "123456");
        for(int i=2000;i<2500;i++){
            String sql = "insert into tb2 (id,val) values ("+i+",'huang"+i+"')";
            System.out.println(db.execute(sql));
        
        }
        
    }

}
