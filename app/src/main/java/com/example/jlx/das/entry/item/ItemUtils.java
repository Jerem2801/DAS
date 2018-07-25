package com.example.jlx.das.entry.item;

import com.google.common.collect.Lists;

import java.util.List;

public class ItemUtils {

    private ItemUtils(){

    }

    public static List<String> getNamesOfItemsInList(List<Item> items){
        List<String> names = Lists.newArrayList();
        for(Item item : items){
            names.add(item.getName());
        }
        return names;
    }

    public static String[] getNamesOfItemsInArray(List<Item> items){
        List<String> names = getNamesOfItemsInList(items);
        return names.toArray(new String[names.size()]);
    }
}
