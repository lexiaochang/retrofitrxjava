package com.chris.retrofitrxjava.model.impl;

import android.util.Log;

import com.chris.retrofitrxjava.bean.DataMapBean;
import com.chris.retrofitrxjava.common.IApiService;
import com.chris.retrofitrxjava.http.Fault;
import com.chris.retrofitrxjava.http.ObjectLoader;
import com.chris.retrofitrxjava.http.PayLoad;
import com.chris.retrofitrxjava.http.RetrofitServiceManager;
import com.chris.retrofitrxjava.model.ITestModel;
import com.chris.retrofitrxjava.presenter.ITestListener;

import rx.functions.Action1;

/**
 * Created by Chris on 2017/12/14.
 */

public class TestModel extends ObjectLoader implements ITestModel {

    private final IApiService mIApiService;

    public TestModel() {
        mIApiService = RetrofitServiceManager.getInstance().create();
    }

    @Override
    public void getList(final ITestListener mITestListener, String id) {
        observe(mIApiService.getList(id))
                .map(new PayLoad<DataMapBean>())
                .subscribe(new Action1<DataMapBean>() {
                    @Override
                    public void call(DataMapBean movies) {
                        mITestListener.onSuccess(movies.getName() + "====" + movies.getAge());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e("====", "error message:" + throwable.getMessage());
                        if (throwable instanceof Fault) {
                            Fault fault = (Fault) throwable;
                            Log.e("====", "error message:" + fault.getErrorCode());
                            mITestListener.onError(fault.getErrorCode());
                        }
                    }
                });
    }
}
