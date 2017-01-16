package com.app.liulongbing.person;

import android.app.Application;
import android.graphics.Bitmap;

/**
 * Created by liulongbing on 17/1/16.
 */

public class PersonApplication extends Application{

    private Bitmap mScreenCaptureBitmap;


    @Override
    public void onCreate() {
        super.onCreate();
    }

    public Bitmap getmScreenCaptureBitmap() {
        return mScreenCaptureBitmap;
    }

    public void setmScreenCaptureBitmap(Bitmap mScreenCaptureBitmap) {
        this.mScreenCaptureBitmap = mScreenCaptureBitmap;
    }

}
