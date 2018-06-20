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

    private static Integer getRandomInt(){
        Random rand = new Random();
        int randomNum = rand.nextInt((1000 - 1) + 1) + 1;
        return randomNum;
    }

    public static Integer getRandomId(Context context){
        Integer i = 0;
        while(isResourceIdInResources(context,i)){
            i = getRandomInt();
        }
        return i;
    }

    private static boolean isResourceIdInResources(Context context, int randomId){
        try{
            context.getResources().getResourceName(randomId);
            return true;
        }catch (Resources.NotFoundException e){
            return false;
        }
    }

    public static Integer getId(View view){
        int i = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            i = view.generateViewId();
        }
        return i;
    }
}
