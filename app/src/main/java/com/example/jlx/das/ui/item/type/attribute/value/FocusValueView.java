package com.example.jlx.das.ui.item.type.attribute.value;

import android.content.Context;

import com.example.jlx.das.entry.character.Character;
import com.example.jlx.das.entry.rule.ItemRule;
import com.google.android.flexbox.FlexboxLayout;

import java.util.Map;

public interface FocusValueView {

    public abstract void createValueView(Context context, ItemRule itemRule, String value, Map<ItemRule,Integer> rules, Character character,FlexboxLayout flexboxLayout);
}
