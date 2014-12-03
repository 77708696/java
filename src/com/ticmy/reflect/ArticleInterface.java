package com.ticmy.reflect;

public interface ArticleInterface {
    public void del(long id) throws Exception;
    public void add(String content) throws Exception;
    public void modify(long id, String content) throws Exception;
    public void list();
}
