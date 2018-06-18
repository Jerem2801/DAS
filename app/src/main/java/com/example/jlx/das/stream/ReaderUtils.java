package com.example.jlx.das.stream;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ReaderUtils {

    private ReaderUtils(){

    }

    public static List<String> readFileWithList(InputStream is)  {
        List<String> lines = new ArrayList<>();
        BufferedReader br = null;
        InputStreamReader isr = null;

        try {
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String line;
            while(( line = br.readLine()) != null ) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            StreamUtils.close(br,isr,is);
        }

        return lines;
    }



}
