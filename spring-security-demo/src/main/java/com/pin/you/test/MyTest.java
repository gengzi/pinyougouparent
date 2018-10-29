package com.pin.you.test;

public class MyTest {

    public static void main(String[] args){
//        Li li = new Li();
//        Wang wang = new Wang(li);
//
//        wang.ask();

        CallBack callBack = new CallBack() {
            @Override
            public void callBack(String value) {
                System.out.println("打印" + value);
            }
        };

        callBack.callBack("你好");


    }
}
