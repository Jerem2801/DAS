package com.example.jlx.das.ui.custom.view.normal;

import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.custom.view.CustomItemView;

public class CustomNormalView extends CustomItemView {

    public CustomNormalView(ItemRule rule, String value,String mode) {
        super(rule, value);
        this.setCustomLayoutView(new CustomNormalLayoutView());
        this.setCustomTitleView(new CustomNormalTitleView());
        this.setCustomValueView(new CustomNormalValueView());
    }
}
