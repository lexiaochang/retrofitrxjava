package com.chris.retrofitrxjava.loader;

import com.chris.retrofitrxjava.bean.Movie;
import com.chris.retrofitrxjava.common.IApiService;
import com.chris.retrofitrxjava.http.ObjectLoader;
import com.chris.retrofitrxjava.http.RetrofitServiceManager;
import com.chris.retrofitrxjava.resp.MovieSubject;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Chris on 2017/12/13.
 */

public class MovieLoader extends ObjectLoader {

    private final IApiService mIApiService;

    public MovieLoader(){
        mIApiService = RetrofitServiceManager.getInstance().create();
    }

    /**
     * 获取电影列表
     * @param start
     * @param count
     * @return
     */
    public Observable<List<Movie>> getMovie(int start, int count){
        return observe(mIApiService.getTop250(start,count))
                .map(new Func1<MovieSubject, List<Movie>>() {
                    @Override
                    public List<Movie> call(MovieSubject movieSubject) {
                        return movieSubject.subjects;
                    }
                });
    }

    public Observable<String> getWeatherList(String cityId,String key){
        return observe(mIApiService.getWeather(cityId,key)).map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return null;
            }
        });
    }
}