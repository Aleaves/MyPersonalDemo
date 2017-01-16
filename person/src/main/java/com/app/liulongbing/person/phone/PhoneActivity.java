package com.app.liulongbing.person.phone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.liulongbing.person.R;

/**
 * Created by liulongbing on 17/1/15.
 */

public class PhoneActivity extends AppCompatActivity{

    public static final int REQUEST_MEDIA_PROJECTION = 18;


    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_info);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("手机相关信息");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        TextView tv = (TextView) findViewById(R.id.tv);

        StringBuilder sb = new StringBuilder();

        DisplayMetrics metrics = getResources().getDisplayMetrics();


        sb.append("当前手机是否root:"+DeviceUtils.isDeviceRooted()+"\n");
        sb.append("屏幕密度:"+metrics.density+"\n");
        sb.append("屏幕像素密度:"+metrics.densityDpi+"\n");
        sb.append("屏幕分辨率:"+metrics.widthPixels+"*"+metrics.heightPixels+"\n");
        sb.append("SDK版本:"+ Build.VERSION.SDK_INT+"\n");
        sb.append("手机型号:"+DeviceUtils.getModel()+"\n");
        sb.append("设备AndroidID:"+DeviceUtils.getAndroidID(this)+"\n");
        sb.append("设备厂商:"+DeviceUtils.getManufacturer()+"\n");
        sb.append(ScreenUtils.isPortrait(this)?"竖屏":"横屏");


        tv.setText(sb.toString());

        final ImageView iv = (ImageView)findViewById(R.id.iv);

        findViewById(R.id.bt_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //requestCapturePermission();
                iv.setImageBitmap(activityShot(PhoneActivity.this));
            }
        });

    }

    /**
     * 获取屏幕截图
     * 推荐网址:http://www.jianshu.com/p/820b2f1597d1
     *
     * @param activity
     * @return
     */

    public static Bitmap activityShot(Activity activity) {
         /*获取windows中最顶层的view*/
        View view = activity.getWindow().getDecorView();

        //允许当前窗口保存缓存信息
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();

        //获取状态栏高度
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int statusBarHeight = rect.top;

        WindowManager windowManager = activity.getWindowManager();

        //获取屏幕宽和高
        DisplayMetrics outMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        int height = outMetrics.heightPixels;

        //去掉状态栏
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache(), 0, statusBarHeight, width,
                height-statusBarHeight);

        //销毁缓存信息
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);

        return bitmap;
    }


    public void requestCapturePermission(){

        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.LOLLIPOP){
            return;
        }

        MediaProjectionManager mediaProjectionManager = (MediaProjectionManager)getSystemService(Context.MEDIA_PROJECTION_SERVICE);

        startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(),REQUEST_MEDIA_PROJECTION);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_MEDIA_PROJECTION:
                if(resultCode ==RESULT_OK&&data!=null){
                    FloatWindowsService.setResultData(data);
                    startService(new Intent(getApplicationContext(), FloatWindowsService.class));
                }

                break;
        }
    }
}
