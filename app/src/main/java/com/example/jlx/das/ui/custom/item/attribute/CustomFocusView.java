package com.example.jlx.das.ui.custom.item.attribute;

import android.content.Context;
import android.widget.LinearLayout;

import com.example.jlx.das.entry.character.Character;
import com.example.jlx.das.entry.rule.ItemRule;

import java.util.Map;

public interface CustomFocusView {

    public abstract void createValueView(Context context, ItemRule itemRule, String value, Map<ItemRule,Integer> rules, Character character);
}
