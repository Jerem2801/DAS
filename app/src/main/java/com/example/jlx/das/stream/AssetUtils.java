package com.example.jlx.das.stream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AssetUtils {

    private AssetUtils(){

    }

    public static List<String> getData(Context context, String path){
        List<String> data = new ArrayList<>();
        InputStream is = null;


        try {
            is = context.getAssets().open(path);
            data = ReaderUtils.readFileWithList(is);
        } catch (IOException e) {
            //TO-DO
        }

        return data;
    }

    public static boolean isDirectory(AssetManager mgr, String path){
        boolean check = false;
        try {
            String list[] = mgr.list(path);
            if(list != null && list.length != 0){
                check = true;
            }
        } catch (IOException e) {
            //TO-DO
        }
        return check;
    }

}
