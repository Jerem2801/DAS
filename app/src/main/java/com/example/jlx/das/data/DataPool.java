package com.example.jlx.das.data;

import android.content.Context;

import com.example.jlx.das.entry.item.Item;

import java.util.Map;

public class DataPool {

    private static DataPool dataPool;
    private Map<String,Map<String,Item>> items;

    public Map<String, Map<String, Item>> getItems() {
        return items;
    }

    public void setItems(Map<String, Map<String, Item>> items) {
        this.items = items;
    }

    public synchronized static DataPool initialize(Context context){
        if(dataPool == null){
            dataPool = DataPoolFactory.getDataLoader(context);
        }
        return dataPool;
    }

    public synchronized static DataPool getInstance(){
        return dataPool;
    }

}
