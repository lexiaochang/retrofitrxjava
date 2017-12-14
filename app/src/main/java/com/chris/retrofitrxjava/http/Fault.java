package com.chris.retrofitrxjava.http;

import android.content.Intent;
import android.util.Log;

import com.chris.retrofitrxjava.ChirsApplication;
import com.chris.retrofitrxjava.view.MainActivity;

/**
 * Created by Chris on 2017/12/13.
 * 异常处理类，将异常包装成一个 Fault ,抛给上层统一处理
 */

public class Fault extends RuntimeException {
    private int errorCode;

    public Fault(int errorCode,String message){
        super(message);
        errorCode = errorCode;
        if (errorCode == -401){
            ChirsApplication.getAppContext().startActivity(new Intent(ChirsApplication.getAppContext(), MainActivity.class));
        }else if (errorCode == 404){
            Log.e("======","error message:"+errorCode);
        }
    }

    public int getErrorCode() {
        return errorCode;
    }
}
