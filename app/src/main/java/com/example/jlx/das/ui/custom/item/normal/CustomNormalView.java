package com.example.jlx.das.ui.custom.item.normal;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jlx.das.entry.character.Character;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.UiUtils;
import com.example.jlx.das.ui.custom.item.CustomItemView;
import com.example.jlx.das.ui.custom.view.IdUtils;

import java.util.Map;


public class CustomNormalView extends CustomItemView {

    private CustomNormalLayoutView customLayoutView;
    private CustomNormalTitleView customTitleView;
    private CustomValueView customValueView;

    public CustomNormalView(ItemRule rule, String value) {
        super(rule,value);
        this.customLayoutView = new CustomNormalLayoutView();
        this.customTitleView = new CustomNormalTitleView();
        this.customValueView = new CustomNormalValueView();
    }


    public void setCustomValueView(CustomValueView customValueView) {
        this.customValueView = customValueView;
    }

    @Override
    @SuppressLint("NewApi")
    public LinearLayout createItemView(Context context, Map<ItemRule,Integer> rules,Character character,LinearLayout mother){
        LinearLayout layoutView = customLayoutView.createLayoutView(context,itemRule);

        TextView titleView = customTitleView.createTitleView(context, itemRule);
        layoutView.addView(titleView);

        View valueView = customValueView.createValueView(context,itemRule,value);

        IdUtils.setIdToView(valueView,itemRule,rules);

        layoutView.addView(valueView);

        return layoutView;
    }
}
