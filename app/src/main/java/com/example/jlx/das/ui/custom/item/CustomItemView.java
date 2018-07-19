package com.example.jlx.das.ui.custom.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.UiUtils;

import java.util.Map;
import java.util.UUID;


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

    @SuppressLint("NewApi")
    public LinearLayout createItemView(Context context,Map<Integer,ItemRule> rules){
        LinearLayout layoutView = customLayoutView.createLayoutView(context,itemRule);

        TextView titleView = customTitleView.createTitleView(context, itemRule);
        layoutView.addView(titleView);

        View valueView = customValueView.createValueView(context,itemRule,value);

        int id = UiUtils.getId(valueView);
        valueView.setId(id);
        rules.put(id, itemRule);

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
