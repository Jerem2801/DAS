package com.example.jlx.das.data;

import com.example.jlx.das.entry.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataPoolManager {

    private DataPoolManager(){

    }

    public static Item getItem(String type, String id){
        Item item = null;
        DataPool instance = DataPool.getInstance();
        Map<String, Item> itemsById = instance.getItems().get(type);
        if(itemsById != null && !itemsById.isEmpty()){
            item = itemsById.get(id);
        }
        return item;
    }

    public static List<Item> getItems(String type){
        DataPool instance = DataPool.getInstance();
        Map<String, Item> itemsById = instance.getItems().get(type);
        return new ArrayList(itemsById.values());
    }

}
