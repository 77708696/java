package com.ticmy.reflect;
import java.io.*;

public class TestDataStream {

    public static void main(String[] args) throws Exception{
        FileOutputStream fos=new FileOutputStream("config.properties");
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        DataOutputStream dos=new DataOutputStream(bos);
        
        FileInputStream fis=new FileInputStream("config.properties");
        BufferedInputStream bis=new BufferedInputStream(fis);
        DataInputStream dis=new DataInputStream(bis);
        String str="hi";
        dos.writeUTF(str);   //按UTF-8格式写入
        
        System.out.println(dis.read());
        
    }

}
