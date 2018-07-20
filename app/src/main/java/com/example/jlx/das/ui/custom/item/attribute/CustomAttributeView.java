package com.example.jlx.das.ui.custom.item.attribute;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.UiUtils;
import com.example.jlx.das.ui.custom.item.CustomItemView;

import java.util.Map;

public class CustomAttributeView extends CustomItemView {


    public CustomAttributeView(ItemRule itemRule, String value) {
        super(itemRule, value);
    }

    @Override
    @SuppressLint("NewApi")
    public LinearLayout createItemView(Context context, Map<Integer,ItemRule> rules){


        return null;
    }
}
