package com.example.jlx.das.data;


import android.content.Context;

import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.entry.item.ItemReader;
import com.example.jlx.das.stream.AssetUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class DataPoolReader {

    private static final String DIRECTORY_PATH = "data/";
    private static final String RACE = "race";
    private static final String CLASSE = "classe";
    private static final String BACKGROUND = "background";
    private static final String SPECIALIZATION = "specialization";
    private static final List<String> dataIds = Lists.newArrayList();
    static{
        dataIds.add(RACE);
        dataIds.add(CLASSE);
        dataIds.add(BACKGROUND);
        dataIds.add(SPECIALIZATION);
    }

    public static final String CSV =".csv";

    private DataPoolReader(){

    }

    public static Map<String,Map<String,Item>> getData(Context context){
        Map<String,Map<String,Item>> itemsByType = Maps.newHashMap();

        for(String dataId : dataIds){
            String path = DIRECTORY_PATH + dataId + CSV;
            List<String> datas = AssetUtils.getData(context, path);
            Map<String,Item> itemsById = ItemReader.getItemsWithId(datas);
            itemsByType.put(dataId,itemsById);
        }

        return itemsByType;
    }





}
