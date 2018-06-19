package com.example.jlx.das.ui.custom.view;

import android.content.Context;
import android.widget.TextView;

import com.example.jlx.das.entry.rule.ItemRule;

public interface CustomValueView {

    public abstract TextView createValueView(Context context, ItemRule itemRule,String value);
}
