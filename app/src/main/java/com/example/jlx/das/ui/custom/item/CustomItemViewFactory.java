package com.example.jlx.das.ui.custom.item;

import com.example.jlx.das.controller.fragment.ModeType;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.custom.item.normal.CustomNormalValueEditView;
import com.example.jlx.das.ui.custom.item.normal.CustomNormalView;
import com.google.common.collect.Maps;

import java.util.Map;

public enum CustomItemViewFactory {
    NORMAL("normal") {
        @Override
        public CustomItemView createCustomItemView(ItemRule itemRule, String value, ModeType modeType) {
            CustomNormalView customNormalView = new CustomNormalView(itemRule, value);
            if(modeType.isSave()){
                customNormalView.setCustomValueView(new CustomNormalValueEditView());
            }
            return customNormalView;
        }
    };

    private String typeView;

    CustomItemViewFactory(String typeView){
        this.typeView = typeView;
    }

    public abstract CustomItemView createCustomItemView(ItemRule itemRule, String value, ModeType modeType);

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

    public static CustomItemView getCustomItemView(ItemRule itemRule, String value, ModeType modeType){
        CustomItemViewFactory customItemViewFactory = getCustomItemViewFactory(itemRule.getTypeView());
        return customItemViewFactory.createCustomItemView(itemRule, value, modeType);
    }


}
