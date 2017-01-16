package com.app.liulongbing.person.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

import com.app.liulongbing.person.R;

import java.util.List;

/**
 * Created by liulongbing on 17/1/15.
 */

public class ExitDialog extends AlertDialog{

    private Context mContext;

    protected ExitDialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    public ExitDialog(Context context, int themeResId) {
        super(context, themeResId);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_exit);

        //设置对话框占屏幕的宽度
        Window window = getWindow();
        WindowManager manager = ((Activity)mContext).getWindowManager();
        WindowManager.LayoutParams params = window.getAttributes();
        //设置dialog处于屏幕的位置
        window.setGravity(Gravity.CENTER);
        Display d = manager.getDefaultDisplay();
        //dialog的宽度占屏幕的0.9
        params.width = (int) (d.getWidth()*0.9);

        //设置dialog位置的偏移量
        params.x=0;
        params.y=0;

        window.setAttributes(params);
    }
}
