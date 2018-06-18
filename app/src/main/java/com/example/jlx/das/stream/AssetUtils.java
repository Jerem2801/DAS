package com.example.jlx.das.stream;

import android.content.Context;

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
}
