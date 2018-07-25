package com.example.jlx.das.ui.custom.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jlx.das.entry.character.Character;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.UiUtils;

import java.util.Map;
import java.util.UUID;


public abstract class CustomItemView {

    protected ItemRule itemRule;
    protected String value;

    public CustomItemView(ItemRule itemRule, String value) {
        this.itemRule = itemRule;
        this.value = value;
    }

    @SuppressLint("NewApi")
    public abstract LinearLayout createItemView(Context context, Map<ItemRule,Integer> rules, Character character,LinearLayout mother);



}
