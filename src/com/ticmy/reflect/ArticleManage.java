package com.ticmy.reflect;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
 
public class ArticleManage implements ArticleInterface {
    private final Map<Long, String> articles;
    private boolean needCheck;
    private final AtomicLong idIncr = new AtomicLong(1);
    public ArticleManage(boolean needCheck) {
        System.out.println("带参数的构造方法");
        this.needCheck = needCheck;
        articles = new ConcurrentHashMap<Long, String>();
    }
 
    public ArticleManage() {
        System.out.println("默认构造方法");
        this.needCheck = true;
        articles = new ConcurrentHashMap<Long, String>();
    }
 
    public void del(long id) throws Exception {
        System.out.println("删除文章");
        articles.remove(id);
    }
 
    public void add(String content) throws Exception {
        if((!isNeedCheck()) || checkContent()) {
            System.out.println("添加文章");
            articles.put(idIncr.getAndIncrement(), content);
        }
    }
    
    public void list(){
        for(Long key : articles.keySet()){
            System.out.println(key + ":" +articles.get(key));
        }
    }
 
    public void modify(long id, String content) throws Exception {
        if((!isNeedCheck()) || checkContent()) {
            System.out.println("修改文章内容");
            articles.put(id, content);
        }
    }
 
    public boolean checkContent() throws Exception {
        System.out.println("检查文章内容");
        Random random = new Random();
        int value = random.nextInt(100);
        if(value < 20) {
            //20%概率失败
           // throw new Exception("文章内容不合法");
        }
        return true;
    }
 
    public boolean isNeedCheck() {
        return needCheck;
    }
}
