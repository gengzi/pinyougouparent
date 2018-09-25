package com.pinyougou.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/9/
 * 响应的实体对象
 * @author  gengzi
 * @date 2018年9月21日10:21:03
 */
public class Result implements Serializable{

    private String message;
    private boolean success;


    public Result(boolean success, String message) {
        this.message = message;
        this.success = success;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
