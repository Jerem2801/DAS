package com.example.jlx.das.ui.item.type.normal.value;

import android.content.Context;
import android.view.View;

import com.example.jlx.das.entry.rule.ItemRule;

import java.util.Map;

public interface NormalValueView {

    public abstract View createValueView(Context context, ItemRule itemRule, String value,Map<ItemRule,Integer> rules);
}
