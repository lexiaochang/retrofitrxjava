package com.chris.retrofitrxjava.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.chris.retrofitrxjava.R;
import com.chris.retrofitrxjava.base.BaseActivity;
import com.chris.retrofitrxjava.bean.DataMapBean;
import com.chris.retrofitrxjava.http.Fault;
import com.chris.retrofitrxjava.loader.TestLoader;

import rx.functions.Action1;

/**
 * Created by Chris on 2017/12/14.
 */

public class TestActivity extends BaseActivity {
private static String TAG = "TestActivity";
    private TestLoader mTestLoader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTestLoader = new TestLoader();
        mTestLoader.getList("3").subscribe(new Action1<DataMapBean>() {
            @Override
            public void call(DataMapBean movies) {
                Log.e(TAG,"movies message:"+movies.getName());

            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.e(TAG,"error message:"+throwable.getMessage());
                if(throwable instanceof Fault) {
                    Fault throwable1 = (Fault) throwable;
                    Log.e("======","error message:"+throwable1.getErrorCode());
                }
            }
        });
    }
}
