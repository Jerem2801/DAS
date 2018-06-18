package com.example.jlx.das.entry.rule;

import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.stream.ReaderConstant;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class ItemRuleReader {

    private static final int ID = 0;
    private static final int NAME = 1;
    private static final int DESCRIPTION = 2;
    private static final int ORDER = 3;
    private static final int TYPE_VALUE = 4;
    private static final int REFERCENCE = 5;


    private ItemRuleReader(){

    }

    public static Map<String,ItemRule> getItemsRuleWithId(List<String> datas){
        Map<String,ItemRule> itemsRule = Maps.newHashMap();

        for(String data : datas){
            String[] splitData = StringUtils.split(data, ReaderConstant.SEPARATOR);
            String id = splitData[ID];
            String name = splitData[NAME];
            String description = splitData[DESCRIPTION];
            int order = Integer.parseInt(splitData[ORDER]);
            String typeValue = splitData[TYPE_VALUE];
            String reference = splitData[REFERCENCE];

            ItemRule itemRule = new ItemRule(id,name,description,order,typeValue,reference);
            itemsRule.put(id,itemRule);
        }

        return itemsRule;
    }


}
