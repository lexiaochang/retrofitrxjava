package com.chris.retrofitrxjava.http;

import android.content.Context;
import android.content.Intent;

import com.chris.retrofitrxjava.ChirsApplication;
import com.chris.retrofitrxjava.base.BaseResponse;
import com.chris.retrofitrxjava.base.CommonAction;
import com.chris.retrofitrxjava.view.activity.LoginActivity;

import rx.functions.Func1;

/**
 * Created by Chris on 2017/12/13.
 * 剥离 最终数据
 */

public class PayLoad<T> implements Func1<BaseResponse<T>, T> {
    @Override
    public T call(BaseResponse<T> tBaseResponse) {//获取数据失败时，包装一个Fault 抛给上层处理错误
        if (tBaseResponse.getStatus() == 1001) {
            Context appContext = ChirsApplication.getAppContext();
            Intent intent = new Intent(appContext, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            appContext.startActivity(new Intent(appContext, LoginActivity.class));
            CommonAction.getInstance().OutSign();
        } else if (!tBaseResponse.isSuccess()) {
            throw new Fault(tBaseResponse.getStatus(), tBaseResponse.getMessage());
        }
        return tBaseResponse.getDataMap();
    }
}

