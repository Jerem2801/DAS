package com.example.jlx.das.entry.item;

import com.example.jlx.das.stream.ReaderConstant;
import com.google.common.collect.Maps;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class ItemReader {

    private static final int ID = 0;
    private static final int NAME = 1;
    private static final int DESCRIPTION = 2;
    private static final String EMPTY = "empty";

    private ItemReader(){

    }

    public static Map<String,Item> getItemsWithId(List<String> datas){
        Map<String,Item> itemsWithId = Maps.newHashMap();

        for(String data : datas){
            String[] splitData = StringUtils.split(data, ReaderConstant.SEPARATOR);
            String id = splitData[ID];
            String name = splitData[NAME];
            String description = transformEmpty(splitData[DESCRIPTION]);


            Item item = new Item(id,name,description);
            itemsWithId.put(id,item);
        }

        return itemsWithId;
    }

    private static String transformEmpty(String value){
        if(StringUtils.equals(EMPTY,value)){
            value = StringUtils.EMPTY;
        }
        return value;
    }
}
