package com.pin.you.test;

public class Wang implements  CallBack {

    private Li li;

    public Wang(Li li) {
        this.li = li;
    }

    public void ask(){

        li.executeMessage(Wang.this);

    }

    @Override
    public  void callBack(String value){
        System.out.println(value);
    }
}
