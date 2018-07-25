package com.example.jlx.das.ui.item.type;

import com.example.jlx.das.controller.fragment.ModeType;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.item.type.attribute.AttributeView;
import com.example.jlx.das.ui.item.type.attribute.value.AttributeValueViewEdit;
import com.example.jlx.das.ui.item.type.attribute.value.FocusValueViewEdit;
import com.example.jlx.das.ui.item.type.normal.value.NormalValueViewEdit;
import com.example.jlx.das.ui.item.type.normal.NormalView;
import com.google.common.collect.Maps;

import java.util.Map;

public enum TypeViewFactory {
    NORMAL("normal") {
        @Override
        public TypeView createCustomItemView(ItemRule itemRule, String value, ModeType modeType) {
            NormalView normalView = new NormalView(itemRule, value);
            if(modeType.isSave()){
                normalView.setNormalValueView(new NormalValueViewEdit());
            }
            return normalView;
        }
    },
    ATTRIBUTE("attribute"){
        @Override
        public TypeView createCustomItemView(ItemRule itemRule, String value, ModeType modeType) {
            AttributeView attributeView = new AttributeView(itemRule, value);
            if(modeType.isSave()){
                attributeView.setAttributeValueView(new AttributeValueViewEdit());
                attributeView.setFocusValueView(new FocusValueViewEdit());
            }
            return attributeView;
        }
    };

    private String typeView;

    TypeViewFactory(String typeView){
        this.typeView = typeView;
    }

    public abstract TypeView createCustomItemView(ItemRule itemRule, String value, ModeType modeType);

    private final static Map<String,TypeViewFactory> processorFactoryByType = Maps.newHashMap();
    static{
        for(TypeViewFactory typeViewFactory : TypeViewFactory.values()){
            processorFactoryByType.put(typeViewFactory.typeView, typeViewFactory);
        }
    }

    private static TypeViewFactory getCustomItemViewFactory(String typeView){
        TypeViewFactory typeViewFactory = processorFactoryByType.get(typeView);
        if(typeViewFactory == null){
            typeViewFactory = NORMAL;
        }
        return typeViewFactory;
    }

    public static TypeView getCustomItemView(ItemRule itemRule, String value, ModeType modeType){
        TypeViewFactory typeViewFactory = getCustomItemViewFactory(itemRule.getTypeView());
        return typeViewFactory.createCustomItemView(itemRule, value, modeType);
    }


}
