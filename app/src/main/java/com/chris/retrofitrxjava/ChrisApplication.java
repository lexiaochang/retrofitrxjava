package com.chris.retrofitrxjava;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/**
 * Created by Chris on 2017/12/13.
 */

public class ChrisApplication extends Application {

    private static Context mContext;

    private static final int MEMORY_SIZE = 5 * 1024 * 1024;
    private static final int DISK_SIZE   = 20 * 1024 * 1024;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        // 初始化 Image-Loader
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .memoryCache(new LruMemoryCache(MEMORY_SIZE))
                .diskCache(new UnlimitedDiscCache(new File(getCacheDir(), "caches")))
                .diskCacheSize(DISK_SIZE)
                .defaultDisplayImageOptions(options)
                .build();

        ImageLoader.getInstance().init(configuration);
    }

    public static Context getAppContext() {
        return mContext;
    }

}
