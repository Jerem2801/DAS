package com.example.jlx.das.ui.item.type.attribute.value;

import android.content.Context;
import android.widget.LinearLayout;

import com.example.jlx.das.entry.character.Character;
import com.example.jlx.das.entry.rule.ItemRule;

import java.util.Map;

public interface AttributeValueView {

    public abstract LinearLayout createValueView(Context context, ItemRule itemRule, String value, Map<ItemRule,Integer> rules, Character character);
}
