package com.example.jlx.das.ui.custom.item;

import com.example.jlx.das.entry.ValueUtils;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.custom.item.normal.CustomNormalView;
import com.google.common.collect.Maps;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public enum CustomItemViewFactory {
    NORMAL("normal") {
        @Override
        public CustomItemView createCustomItemView(ItemRule itemRule, String value, String mode) {
            return new CustomNormalView(itemRule,value,mode);
        }
    };

    private String typeView;

    CustomItemViewFactory(String typeView){
        this.typeView = typeView;
    }

    public abstract CustomItemView createCustomItemView(ItemRule itemRule, String value, String mode);

    private final static Map<String,CustomItemViewFactory> processorFactoryByType = Maps.newHashMap();
    static{
        for(CustomItemViewFactory customItemViewFactory : CustomItemViewFactory.values()){
            processorFactoryByType.put(customItemViewFactory.typeView,customItemViewFactory);
        }
    }

    private static CustomItemViewFactory getCustomItemViewFactory(String typeView){
        CustomItemViewFactory customItemViewFactory = processorFactoryByType.get(typeView);
        if(customItemViewFactory == null){
            customItemViewFactory = NORMAL;
        }
        return customItemViewFactory;
    }

    public static CustomItemView getCustomItemView(ItemRule itemRule, String value, String mode){
        CustomItemViewFactory customItemViewFactory = getCustomItemViewFactory(itemRule.getTypeView());
        return customItemViewFactory.createCustomItemView(itemRule, value, mode);
    }


}
