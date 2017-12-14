package com.chris.retrofitrxjava.presenter.impl;

import com.chris.retrofitrxjava.model.impl.TestModel;
import com.chris.retrofitrxjava.presenter.ITestListener;
import com.chris.retrofitrxjava.view.ITestView;

/**
 * Created by Chris on 2017/12/14.
 */

public class TestPresenter implements ITestListener {

    private final ITestView mITestView;
    private final TestModel mTestModel;

    public TestPresenter(ITestView iTestView){
        mITestView = iTestView;
        mTestModel = new TestModel();
    }

    public void getList(String id){
        mTestModel.getList(this,id);
    }


    @Override
    public void onSuccess(String msg) {
        mITestView.onSuccess(msg);
    }

    @Override
    public void onError(int code) {
        mITestView.onError(code);
    }


}
