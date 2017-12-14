package com.chris.retrofitrxjava.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.chris.retrofitrxjava.R;
import com.chris.retrofitrxjava.base.BaseActivity;

/**
 * Created by Chris on 2017/12/14.
 */

public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
