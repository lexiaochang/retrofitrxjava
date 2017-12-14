package com.chris.retrofitrxjava.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chris.retrofitrxjava.R;
import com.chris.retrofitrxjava.base.BaseActivity;

/**
 * Created by Chris on 2017/12/13.
 */

public class MainActivity extends BaseActivity{

    private TextView mTv;
    private TextView mTv1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv = (TextView) findViewById(R.id.tv);
        mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TestActivity.class));
            }
        });
        mTv1 = (TextView) findViewById(R.id.tv1);
        mTv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,GankActivity.class));
            }
        });
    }
}
