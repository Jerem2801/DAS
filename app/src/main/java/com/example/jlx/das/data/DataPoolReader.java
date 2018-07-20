package com.example.jlx.das.data;


import android.content.Context;
import android.content.res.AssetManager;

import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.entry.item.ItemReader;
import com.example.jlx.das.stream.AssetUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DataPoolReader {

    private static final String DIRECTORY_PATH = "data";

    public static final String CSV =".csv";
    public static final String SEPARATOR ="/";

    private DataPoolReader(){

    }

    public static Map<String,Map<String,Item>> getData(Context context){
        AssetManager assets = context.getAssets();
        Map<String,Map<String,Item>> itemsByType = Maps.newHashMap();
        try {
            getDatas(context,assets,itemsByType,DIRECTORY_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return itemsByType;
    }

    public static void getDatas(Context context, AssetManager assets,Map<String,Map<String,Item>> itemsByType,String rootPath) throws IOException {
        String[] paths = assets.list(rootPath);
        for(String path : paths){
            path = rootPath + SEPARATOR + path;
            if(!AssetUtils.isDirectory(assets,path)){
                List<String> datas = AssetUtils.getData(context, path);
                Map<String,Item> itemsById = ItemReader.getItemsWithId(datas);
                String dataId = StringUtils.remove(path,rootPath);
                dataId = StringUtils.remove(dataId,CSV);
                dataId = StringUtils.remove(dataId,SEPARATOR);
                itemsByType.put(dataId,itemsById);
            }else{
                getDatas(context,assets,itemsByType,path);
            }
        }
    }








}
