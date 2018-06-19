package com.example.jlx.das.ui;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    private ToastUtils(){

    }

    public static void showToast(Context context, String message){
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }
}
