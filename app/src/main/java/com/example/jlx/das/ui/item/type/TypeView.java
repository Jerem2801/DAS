package com.example.jlx.das.ui.item.type;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.LinearLayout;

import com.example.jlx.das.entry.character.Character;
import com.example.jlx.das.entry.rule.ItemRule;

import java.util.Map;


public abstract class TypeView {

    protected ItemRule itemRule;
    protected String value;

    public TypeView(ItemRule itemRule, String value) {
        this.itemRule = itemRule;
        this.value = value;
    }

    @SuppressLint("NewApi")
    public abstract LinearLayout createItemView(Context context, Map<ItemRule,Integer> rules, Character character,LinearLayout mother);



}
