package com.ticmy.reflect;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class Test {

    public static void main(String[] args) throws Exception {
        ArticleManage delegationObj = new ArticleManage();
        
        ArticleInterface inst = (ArticleInterface)Proxy.newProxyInstance(
                ArticleInterface.class.getClassLoader(),
                new Class[]{ArticleInterface.class},
                new ArticleManageInvocationHandler(delegationObj));
        inst.add("this is a short article");
        inst.list();

    }
    static class ArticleManageInvocationHandler implements InvocationHandler {
        private ArticleManage delegationObj;
        public ArticleManageInvocationHandler(ArticleManage delegationObj) {
            this.delegationObj = delegationObj;
        }
        public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
            String methodName = method.getName();
            Object ret = null;
            long start = System.currentTimeMillis();
 
            if(methodName.equals("add")) {
                ret = method.invoke(delegationObj, args);
            } else {
                if((!delegationObj.isNeedCheck()) || delegationObj.checkContent()) {
                    ret = method.invoke(delegationObj, args);
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("[方法调用][" + methodName + "]耗时:" + (end - start) + "ms");
            return ret;
        }
    }
}
