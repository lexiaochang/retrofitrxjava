package com.chris.retrofitrxjava.common;

import com.chris.retrofitrxjava.resp.GankResp;
import com.chris.retrofitrxjava.resp.MovieSubject;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Chris on 2017/12/14.
 */

public interface IApiService {

    //获取豆瓣Top250 榜单
    @GET("top250")
    Observable<MovieSubject> getTop250(@Query("start") int start, @Query("count")int count);

    @FormUrlEncoded
    @POST("/x3/weather")
    Observable<String> getWeather(@Field("cityId") String cityId, @Field("key") String key);

    @GET
    Observable<GankResp> getGank(@Url String url/*, @Path("count")int count,@Path("page")int page*/);



}
