package com.chris.retrofitrxjava.presenter;

/**
 * Created by Chris on 2017/12/14.
 */

public interface ITestListener {
    void onSuccess(String msg);
    void onError(int code);
}
