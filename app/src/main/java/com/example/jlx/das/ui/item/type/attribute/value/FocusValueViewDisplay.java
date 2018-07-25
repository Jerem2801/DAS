package com.example.jlx.das.ui.item.type.attribute.value;

import android.content.Context;
import android.widget.TextView;

import com.example.jlx.das.data.DataPoolManager;
import com.example.jlx.das.entry.character.Character;
import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.entry.rule.ItemRule;
import com.google.android.flexbox.FlexboxLayout;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FocusValueViewDisplay implements FocusValueView{

    public FocusValueViewDisplay(){

    }

    @Override
    public void createValueView(Context context, ItemRule itemRule, String value, Map<ItemRule, Integer> rules, Character character,FlexboxLayout flexboxLayout) {
        List<Item> items = DataPoolManager.getItems(itemRule.getReference());
        List<String> split = Arrays.asList(StringUtils.split(value, "&"));
        for(Item item : items){
            if(split.contains(item.getId())) {
                TextView focus = new TextView(context);
                focus.setText(item.getName());
                flexboxLayout.addView(focus);
            }
        }
    }
}
