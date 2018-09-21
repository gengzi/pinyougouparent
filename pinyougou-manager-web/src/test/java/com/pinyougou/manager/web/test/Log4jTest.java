package com.pinyougou.manager.web.test;

import org.junit.Test;

import org.apache.log4j.Logger;
import sun.rmi.runtime.Log;

/**
 * Created by Administrator on 2018/9/19.
 * 测试log4j
 * @author  gengzi
 * @Date 2018年9月19日21:41:24
 */
public class Log4jTest {

    public static final Logger logger = Logger.getLogger(Log4jTest.class);


    /**
     * 测试在dev 分支提交
     */
    @Test
    public void testLog4jPrint(){

        logger.debug("This is a debug message!");
        logger.info("This is info message!");
        logger.warn("This is a warn message!");
        logger.error("This is error message!");

        try{
            System.out.println(5/0);
        }catch(Exception e){
            logger.error(e);
        }

    }

}
