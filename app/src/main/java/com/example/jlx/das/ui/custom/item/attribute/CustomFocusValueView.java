package com.example.jlx.das.ui.custom.item.attribute;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.example.jlx.das.entry.character.Character;
import com.example.jlx.das.entry.rule.ItemRule;

import java.util.Map;

public interface CustomFocusValueView {

    public abstract LinearLayout createValueView(Context context, ItemRule itemRule, String value, Map<ItemRule,Integer> rules, Character character);
}
