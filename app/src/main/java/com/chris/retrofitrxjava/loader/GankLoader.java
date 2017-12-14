package com.chris.retrofitrxjava.loader;

import com.chris.retrofitrxjava.bean.GankEntry;
import com.chris.retrofitrxjava.common.IApiService;
import com.chris.retrofitrxjava.http.ObjectLoader;
import com.chris.retrofitrxjava.http.RetrofitServiceManager;
import com.chris.retrofitrxjava.resp.GankResp;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Chris on 2017/12/13.
 */

public class GankLoader extends ObjectLoader {
    private static final String GANK_URL = "http://gank.io/api/data/福利/50/1";
    private IApiService mGankService ;
    public GankLoader(){
        mGankService = RetrofitServiceManager.getInstance().create();
    }

    /**
     * 获取干货列表
     * @return
     */
    public Observable<List<GankEntry>> getGankList(){
        return observe(mGankService.getGank(GANK_URL)).map(new Func1<GankResp, List<GankEntry>>() {
            @Override
            public List<GankEntry> call(GankResp gankResp) {
                return gankResp.results;
            }
        });
    }

}
