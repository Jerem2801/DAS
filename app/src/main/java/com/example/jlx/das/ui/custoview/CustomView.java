package com.example.jlx.das.ui.custoview;

import android.content.Context;
import android.widget.LinearLayout;

import com.example.jlx.das.entry.rule.ItemRule;
import com.google.common.collect.Maps;

import java.util.Map;

public abstract class CustomView {

    protected Context context;
    protected LinearLayout mother;
    protected ItemRule itemRule;
    protected String value;


    public CustomView(Context context, LinearLayout mother, ItemRule itemRule, String value) {
        this.context = context;
        this.mother = mother;
        this.itemRule = itemRule;
        this.value = value;
    }

    public abstract void createCustomView();

    public enum CustomModeFactory {
        MODE_DISPLAY {
            @Override
            public CustomView getCustomView(Context context, LinearLayout mother, ItemRule itemRule, String value) {
                return new CustomDisplayView(context,mother,itemRule,value);
            }
        },
        MODE_EDIT {
            @Override
            public CustomView getCustomView(Context context, LinearLayout mother, ItemRule itemRule, String value) {
                return new CustomEditView(context,mother,itemRule,value);
            }
        };


        public abstract CustomView getCustomView(Context context, LinearLayout mother, ItemRule itemRule, String value);

        private final static Map<String,CustomModeFactory> processorFactoryByMode = Maps.newHashMap();
        static{
            processorFactoryByMode.put("display",MODE_DISPLAY);
            processorFactoryByMode.put("edit",MODE_EDIT);

        }

        private static CustomModeFactory getCustomViewFactory(String mode){
            return processorFactoryByMode.get(mode);
        }

        public static CustomView getCustomView(Context context, LinearLayout mother, ItemRule itemRule, String value,String mode){
            CustomModeFactory factory = getCustomViewFactory(mode);
            return factory.getCustomView(context,mother,itemRule,value);
        }

    }
}
