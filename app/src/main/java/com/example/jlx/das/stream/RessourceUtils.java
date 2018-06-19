package com.example.jlx.das.stream;

import android.content.Context;

import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RessourceUtils {

    private RessourceUtils(){

    }

    public static List<String> getData(Context context, String fileName)  {
        List<String> content = Lists.newArrayList();
        BufferedReader br = null;
        InputStreamReader isr = null;
        FileInputStream fis = null;
        try {
            fis = context.openFileInput(fileName);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String line;
            while(( line = br.readLine()) != null ) {
                content.add(line);
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }finally {
            StreamUtils.close(br,isr,fis);
        }

        return content;
    }

    public static void writeFile(Context context, String fileName, String content){
        File file = new File(context.getFilesDir(), fileName);
        FileOutputStream outputStream;
        try {
            outputStream = context.openFileOutput(file.getName(), Context.MODE_PRIVATE);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
