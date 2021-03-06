package com.datacvg.dimp.baseandroid.retrofit.bean;

import androidx.annotation.Keep;

/**
 * @Author : T-Bag (茶包)
 * @Time : 2020-07-22
 * @Description : 返回数据基础格式
 */
@Keep
public class BaseBean<T> {
    private String message ;
    private String user_token ;
    private int status ;
    private boolean success ;
    private T resdata ;
    private T data ;

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public String getUser_token() {
        return user_token;
    }

    public int getStatus() {
        return status;
    }

    public T getResdata() {
        return resdata;
    }
}
