package com.example.jlx.das.ui.item.type.attribute.value;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.jlx.das.data.DataPoolManager;
import com.example.jlx.das.entry.character.Character;
import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.listener.CustomClickListListener;
import com.google.android.flexbox.FlexboxLayout;
import com.google.common.collect.Lists;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FocusValueViewEdit implements FocusValueView{

    public FocusValueViewEdit(){

    }

    @Override
    public void createValueView(Context context, ItemRule itemRule, String value, Map<ItemRule, Integer> rules, Character character,FlexboxLayout flexboxLayout) {
        FocusValueViewDisplay focusValueViewDisplay = new FocusValueViewDisplay();
        addSelectedItem(context,value,flexboxLayout, DataPoolManager.getItems(itemRule.getReference()));
        focusValueViewDisplay.createValueView(context,itemRule,value,rules,character,flexboxLayout);
        flexboxLayout.setOnClickListener(new CustomClickListListener(context,flexboxLayout,itemRule,value));
    }

    private static void addSelectedItem(Context context,String value, FlexboxLayout flexboxLayout,List<Item> items){
        List<Integer> selectedItems = Lists.newArrayList();
        List<String> split = Arrays.asList(StringUtils.split(value, "&"));
        int index = 0;
        for(Item item : items){
            if(split.contains(item.getId())) {
                selectedItems.add(index);
            }
            index++;
        }
        String joinIds = StringUtils.join(selectedItems, "&");
        TextView ids = new TextView(context);
        ids.setText(joinIds);
        ids.setVisibility(View.GONE);
        flexboxLayout.addView(ids,0);
    }


}
