package com.example.jlx.das.ui.custom.item.normal;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.example.jlx.das.entry.rule.ItemRule;

public interface CustomValueView {

    public abstract View createValueView(Context context, ItemRule itemRule, String value);
}
