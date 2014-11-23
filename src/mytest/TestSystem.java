package mytest;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
public class TestSystem {
    private static final Logger LOGGER = Logger.getLogger(TestSystem.class);
    public static void main(String[] args) {
        LOGGER.info("===============================================");
        //System.out.println(System.getProperties());
        System.out.println(System.getProperty("user.dir"));
    }

}
