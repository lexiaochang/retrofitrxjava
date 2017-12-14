package com.chris.retrofitrxjava.model;

import com.chris.retrofitrxjava.presenter.ITestListener;

/**
 * Created by Chris on 2017/12/14.
 */

public interface ITestModel {
    void getList(ITestListener iTestListener,String id);
}
