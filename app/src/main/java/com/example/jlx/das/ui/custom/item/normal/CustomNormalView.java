package com.example.jlx.das.ui.custom.item.normal;

import com.example.jlx.das.controller.fragment.CustomFragment;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.custom.item.CustomItemView;

import org.apache.commons.lang3.StringUtils;

public class CustomNormalView extends CustomItemView {

    public CustomNormalView(ItemRule rule, String value,String mode) {
        super(rule, value);
        this.setCustomLayoutView(new CustomNormalLayoutView());
        this.setCustomTitleView(new CustomNormalTitleView());
        this.setCustomValueView(new CustomNormalValueView());
        if(StringUtils.equals(CustomFragment.MODE_EDIT,mode)){
            this.setCustomValueView(new CustomNormalValueEditView());
        }
    }
}
