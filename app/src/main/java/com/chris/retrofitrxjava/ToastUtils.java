package com.chris.retrofitrxjava;

import android.view.View;
import android.widget.Toast;

/**
 * Created by Chris on 2017/12/14.
 */

public class ToastUtils {
    private volatile static ToastUtils instance;
    private int mGravity = -1;
    private int xOffset = 0;
    private int yOffset = 0;
    private Toast mTemp;




    public static ToastUtils getInstance() {
        if (instance == null){
            synchronized (ToastUtils.class){
                if (instance == null){
                    instance = new ToastUtils();
                }
            }
        }
        return instance;
    }

    private ToastUtils(){
    }

    /**
     * 设置该toast的显示位置，只对该toast有效
     */
    public ToastUtils setGravity(int mGravity) {
        this.mGravity = mGravity;
        return getInstance();
    }

    /**
     * 请在{@link #setGravity(int)}调用之后调用，只对该toast有效
     */
    public ToastUtils setxOffset(int xOffset) {
        this.xOffset = xOffset;
        return getInstance();
    }

    /**
     * 请在{@link #setGravity(int)}调用之后调用，只对该toast有效
     */
    public ToastUtils setyOffset(int yOffset) {
        this.yOffset = yOffset;
        return getInstance();
    }


    /**
     * 需要在toast中显示的v
     */
    public void showShort(String message, View v){
        //防止一堆toast的显示堆积
        if (mTemp != null)
            mTemp.cancel();
        mTemp = Toast.makeText(ChirsApplication.getAppContext(), message, Toast.LENGTH_SHORT);
        if (mGravity != -1)
            mTemp.setGravity(mGravity, xOffset, yOffset);
        if (v != null){
            mTemp.setView(v);
        }
        mTemp.show();
        reset();
    }


    /**
     * 需要在toast中显示的v
     */
    public void showLong(String message, View v){
        //防止一堆toast的显示堆积
        if (mTemp != null)
            mTemp.cancel();
        mTemp = Toast.makeText(ChirsApplication.getAppContext(), message, Toast.LENGTH_LONG);


        if (mGravity != -1)
            mTemp.setGravity(mGravity, xOffset, yOffset);
        if (v != null){
            mTemp.setView(v);
        }
        mTemp.show();
        reset();
    }

    private void reset(){
        mGravity = -1;
        xOffset = 0;
        yOffset = 0;
    }


}
