package com.chris.retrofitrxjava.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.chris.retrofitrxjava.R;
import com.chris.retrofitrxjava.base.BaseActivity;
import com.chris.retrofitrxjava.presenter.impl.TestPresenter;
import com.chris.retrofitrxjava.view.ITestView;

/**
 * Created by Chris on 2017/12/14.
 */

public class TestActivity extends BaseActivity implements ITestView {
private static String TAG = "TestActivity";
    public static TestActivity testActivity = null;
    private TestPresenter mTestPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gank_activity);
        testActivity = this;
        Toolbar tool_bar = (Toolbar)findViewById(R.id.tool_bar);
        tool_bar.setTitleTextColor(getResources().getColor(R.color.white));
        tool_bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mTestPresenter = new TestPresenter(this);
        mTestPresenter.getList("2");
    }

    @Override
    public void onSuccess(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(int code) {
        Toast.makeText(this,code+"",Toast.LENGTH_SHORT).show();
    }
}
