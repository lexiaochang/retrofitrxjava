package com.chris.retrofitrxjava.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.chris.retrofitrxjava.R;
import com.chris.retrofitrxjava.base.BaseActivity;

/**
 * Created by Chris on 2017/12/14.
 */

public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(LoginActivity.this,R.layout.activity_login);


    }
}
