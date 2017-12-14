package com.chris.retrofitrxjava.common;

import com.chris.retrofitrxjava.bean.DataMapBean;
import com.chris.retrofitrxjava.base.BaseResponse;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Chris on 2017/12/14.
 */

public interface IApiService {

    @FormUrlEncoded
    @POST("autoincrement/selectdata")
    Observable<BaseResponse<DataMapBean>> getList(@Field("id") String id);


}
