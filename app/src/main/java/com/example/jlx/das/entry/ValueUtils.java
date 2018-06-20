package com.example.jlx.das.entry;

import android.content.Context;

import com.example.jlx.das.stream.ReaderConstant;
import com.example.jlx.das.stream.RessourceUtils;
import com.google.common.collect.Maps;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class ValueUtils {

    private static final int ID = 0;
    private static final int VALUE = 1;

    public static final String EMPTY = "empty";

    public static boolean isEmpty(String value){
        return StringUtils.equals(EMPTY,value);
    }

    public static Map<String,String> getValues(Context context, String pathValue){
        Map<String,String> values = Maps.newHashMap();
        List<String> valuesData = RessourceUtils.getData(context, pathValue);
        for(String valueData : valuesData){
            String[] splitData = StringUtils.split(valueData, ReaderConstant.SEPARATOR);
            String id = splitData[ID];
            String value = splitData[VALUE];

            values.put(id,value);
        }
        return values;
    }
}
