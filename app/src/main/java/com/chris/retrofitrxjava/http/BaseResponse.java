package com.chris.retrofitrxjava.http;

/**
 * Created by Chris on 2017/12/13.
 * 网络请求结果 基类
 */

public class BaseResponse<T> {
    public int status;
    public String message;

    public T data;

    public boolean isSuccess(){
        return status == 200;
    }
}
