package com.chris.retrofitrxjava.view;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.chris.retrofitrxjava.R;
import com.chris.retrofitrxjava.adapter.GanKAdapter;
import com.chris.retrofitrxjava.base.BaseActivity;
import com.chris.retrofitrxjava.bean.GankEntry;
import com.chris.retrofitrxjava.loader.GankLoader;

import java.util.List;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by Chris on 2017/12/13.
 */

public class GankActivity extends BaseActivity {
    private GankLoader   mGankLoader;
    private RecyclerView mRecyuclerView;
    private GanKAdapter  mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gank_activity);
        mGankLoader = new GankLoader();
        initView();
        getGankList();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setTitle(R.string.award_list);
        mRecyuclerView = (RecyclerView) findViewById(R.id.gank_recycler_view);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mRecyuclerView.setLayoutManager(manager);
        mRecyuclerView.addItemDecoration(new MyItemDecoration());
        mAdapter = new GanKAdapter();
        mRecyuclerView.setAdapter(mAdapter);
    }


    private void getGankList(){
        Subscription subscription = mGankLoader.getGankList().subscribe(new Action1<List<GankEntry>>() {
            @Override
            public void call(List<GankEntry> gankEntries) {
                Log.i("FK","gank size:"+gankEntries.size());
                mAdapter.setData(gankEntries);
                mAdapter.notifyDataSetChanged();
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                throwable.printStackTrace();
                Log.i("FK","throwable"+throwable.getMessage());
            }
        });

        addSubscription(subscription);
    }

    public static class MyItemDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.set(0,0,20,20);
        }
    }
}
