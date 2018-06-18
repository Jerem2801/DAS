package com.example.jlx.das.ui;

import android.content.Context;
import android.util.TypedValue;

public class UiUtils {

    private UiUtils(){

    }

    public static Integer sizeInDp(Context context, int sizeInDp){
        float v = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, sizeInDp, context.getResources().getDisplayMetrics());
        return (Integer) Math.round(v);
    }
}
