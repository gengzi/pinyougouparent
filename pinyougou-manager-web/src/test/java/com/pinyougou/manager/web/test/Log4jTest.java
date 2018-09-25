package com.pinyougou.manager.web.test;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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




}
