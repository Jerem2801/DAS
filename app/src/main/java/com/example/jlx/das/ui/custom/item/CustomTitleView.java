package com.example.jlx.das.ui.custom.item;

import android.content.Context;
import android.widget.TextView;

import com.example.jlx.das.entry.rule.ItemRule;


public interface CustomTitleView {

    public abstract TextView createTitleView(Context context, ItemRule itemRule);
}
