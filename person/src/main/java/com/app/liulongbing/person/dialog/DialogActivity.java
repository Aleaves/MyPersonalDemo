package com.app.liulongbing.person.dialog;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.app.liulongbing.person.R;

import java.util.Calendar;

/**
 * Created by liulongbing on 17/1/14.
 */

/**
 * 1.material-dialogs  地址:https://github.com/afollestad/material-dialogs#table-of-contents-commons
 * 2.FlycoDialog_Master 地址:https://github.com/H07000223/FlycoDialog_Master
 */

public class DialogActivity extends AppCompatActivity{
    Toolbar mToolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("对话框");
        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        findViewById(R.id.bt_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert1();
            }
        });

        findViewById(R.id.bt_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert2();
            }
        });

        findViewById(R.id.bt_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert3();
            }
        });

        findViewById(R.id.bt_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert4();
            }
        });

        findViewById(R.id.bt_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert5();
            }
        });

        findViewById(R.id.bt_6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert6();
            }
        });

        findViewById(R.id.bt_7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert7();
            }
        });
    }


    private void alert1(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("温馨提示");
        builder.setMessage("确定要退出吗?");
        builder.setCancelable(false);
        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }

    private void alert2(){

        final String[] datas = new String[]{"安徽合肥", "浙江杭州", "湖北武汉", "江西南昌",
            "湖南长沙","河南郑州","陕西西安","云南大理","广东广州","江苏南京","山西太原","浙江杭州",
                "福建福州"
        };
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择你的家乡");
        builder.setSingleChoiceItems(datas, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i("========",datas[which]);
                dialog.dismiss();

            }
        });
        builder.create().show();

    }

    private void alert3(){
        //ProgressDialog progressDialog =ProgressDialog.show(this, "提示", "正在下载文件...", true, true);
        //progressDialog.setProgressStyle(ProgressDialog.BUTTON_NEGATIVE);

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("提示");
        progressDialog.setMessage("正在下载文件...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
    }

    private void alert4(){
        Calendar calendar = Calendar.getInstance();
        new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Log.i("========",year+"====="+(month+1)+"====="+dayOfMonth);
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        ).show();

    }

    private void alert5(){
        Calendar calendar = Calendar.getInstance();

        new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.i("========",hourOfDay+"====="+minute);
                    }
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
        ).show();
    }

    private void alert6(){

        String[] items = {"篮球","足球","排球","乒乓球","羽毛球"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(" 选择你喜欢的运动");
        builder.setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                //dialog.dismiss();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();

    }

    private void alert7(){
        new ExitDialog(this,R.style.ExitDialogStyle).show();
    }

}
