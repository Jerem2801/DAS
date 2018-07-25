package com.example.jlx.das.data;

import com.example.jlx.das.entry.item.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        List<Item> items = new ArrayList(itemsById.values());
        Collections.sort(items, new Comparator<Item>() {

            public int compare(Item o1, Item o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return items;
    }

}
