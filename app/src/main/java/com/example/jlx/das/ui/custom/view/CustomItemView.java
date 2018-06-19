package com.example.jlx.das.ui.custom.view;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jlx.das.entry.rule.ItemRule;


public abstract class CustomItemView {

    private ItemRule itemRule;
    private String value;

    private CustomLayoutView customLayoutView;
    private CustomTitleView customTitleView;
    private CustomValueView customValueView;

    public CustomItemView(ItemRule itemRule, String value) {
        this.itemRule = itemRule;
        this.value = value;
    }

    public LinearLayout createItemView(Context context){
        LinearLayout layoutView = customLayoutView.createLayoutView(context,itemRule);
        TextView titleView = customTitleView.createTitleView(context, itemRule);
        layoutView.addView(titleView);
        TextView valueView = customValueView.createValueView(context,itemRule,value);
        layoutView.addView(valueView);
        return layoutView;
    }


    public void setCustomLayoutView(CustomLayoutView customLayoutView) {
        this.customLayoutView = customLayoutView;
    }

    public void setCustomTitleView(CustomTitleView customTitleView) {
        this.customTitleView = customTitleView;
    }

    public void setCustomValueView(CustomValueView customValueView) {
        this.customValueView = customValueView;
    }
}
