package com.chris.retrofitrxjava.http;

/**
 * Created by Chris on 2017/12/13.
 * 异常处理类，将异常包装成一个 Fault ,抛给上层统一处理
 */

public class Fault extends RuntimeException {
    public int mErrorCode;

    public Fault(int errorCode,String message){
        super(message);
        mErrorCode = errorCode;
    }

    public int getErrorCode() {
        return mErrorCode;
    }
}
