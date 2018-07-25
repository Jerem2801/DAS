package com.example.jlx.das.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;

import java.util.Random;

public class UiUtils {

    private UiUtils(){

    }

    public static Integer sizeInDp(Context context, int sizeInDp){
        float v = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, sizeInDp, context.getResources().getDisplayMetrics());
        return (Integer) Math.round(v);
    }

}
