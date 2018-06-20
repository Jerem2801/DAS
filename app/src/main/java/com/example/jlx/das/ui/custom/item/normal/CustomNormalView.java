package com.example.jlx.das.ui.custom.item.normal;

import com.example.jlx.das.controller.fragment.ModeFragment;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.custom.item.CustomItemView;


public class CustomNormalView extends CustomItemView {

    public CustomNormalView(ItemRule rule, String value,ModeFragment modeFragment) {
        super(rule, value);
        this.setCustomLayoutView(new CustomNormalLayoutView());
        this.setCustomTitleView(new CustomNormalTitleView());
        this.setCustomValueView(new CustomNormalValueView());
        if(modeFragment.isSave()){
            this.setCustomValueView(new CustomNormalValueEditView());
        }
    }
}
