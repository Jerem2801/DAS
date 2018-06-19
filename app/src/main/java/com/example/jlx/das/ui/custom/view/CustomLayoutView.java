package com.example.jlx.das.ui.custom.view;

import android.content.Context;
import android.widget.LinearLayout;

import com.example.jlx.das.entry.rule.ItemRule;

public interface CustomLayoutView {

    public abstract LinearLayout createLayoutView(Context context, ItemRule itemRule);
}
