package com.chris.retrofitrxjava.loader;

import com.chris.retrofitrxjava.bean.DataMapBean;
import com.chris.retrofitrxjava.common.IApiService;
import com.chris.retrofitrxjava.http.BaseResponse;
import com.chris.retrofitrxjava.http.ObjectLoader;
import com.chris.retrofitrxjava.http.PayLoad;
import com.chris.retrofitrxjava.http.RetrofitServiceManager;

import rx.Observable;

/**
 * Created by Chris on 2017/12/14.
 */

public class TestLoader extends ObjectLoader {

    private final IApiService mIApiService;

    public TestLoader(){
        mIApiService = RetrofitServiceManager.getInstance().create();
    }

    public Observable<DataMapBean> getList(String id){
        Observable<BaseResponse<DataMapBean>> observe = observe(mIApiService.getList(id));
        return observe.map(new PayLoad<DataMapBean>());
    }
}
