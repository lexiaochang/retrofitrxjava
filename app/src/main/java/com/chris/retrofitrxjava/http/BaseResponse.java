package com.chris.retrofitrxjava.http;

/**
 * Created by Chris on 2017/12/13.
 * 网络请求结果 基类
 */

public class BaseResponse<T> {


    /**
     * dataMap : {"name":"666","age":26}
     * message : 成功
     * status : 200
     */

    private String message;
    private int    status;

    private T dataMap;
    public boolean isSuccess(){
        return status == 200;
    }


    public T getDataMap() {
        return dataMap;
    }

    public void setDataMap(T dataMap) {
        this.dataMap = dataMap;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
