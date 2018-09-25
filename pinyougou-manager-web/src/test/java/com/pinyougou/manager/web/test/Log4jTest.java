package com.pinyougou.manager.web.test;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

//import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2018/9/19.
 * 测试log4j
 * @author  gengzi
 * @Date 2018年9月19日21:41:24
 */
public class Log4jTest {

//    public static final Logger logger = Logger.getLogger(Log4jTest.class);
      public static final Logger logger = LoggerFactory.getLogger(Log4jTest.class);



    /**
     * 使用log4j
     */
    @Ignore
    @Test
    public void testLog4jPrint(){
        Logger logger = LoggerFactory.getLogger(Log4jTest.class);

//        logger.debug("This is a debug message!");
//        logger.info("This is info message!");
//        logger.warn("This is a warn message!");
//        logger.error("This is error message!");
//
//        try{
//            System.out.println(5/0);
//        }catch(Exception e){
//            logger.error(e);
//        }

    }

    /**
     *
     * 使用logback
     */
    @Test
    public void testLogBackPrint(){

        logger.debug("This is a debug message!");
        logger.info("This is info message!");
        logger.warn("This is a warn message!");
        logger.error("This is error message!");

        try{
            System.out.println(5/0);
        }catch(Exception e){
            logger.error(e.toString());
        }

    }


    @Test
    public void test6() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Calendar beforeTime = Calendar.getInstance();
        beforeTime.set(1970, 0, 01);
        //String format = sdf.format(beforeTime.getTime());
        //   System.out.println("哈哈aaa"+ format);
        long timeInMillis = beforeTime.getTimeInMillis();
        System.out.println("当前时间戳" + timeInMillis);
        long ltime = System.currentTimeMillis();
        for (Long aa = 50000L; ltime < timeInMillis; aa = ltime - aa) {
            System.out.println("运行了。。。");
        }

    }


}
