package com.example.jlx.das.ui.custom.view;

import android.content.Context;
import android.widget.LinearLayout;

import com.example.jlx.das.controller.fragment.ModeType;
import com.example.jlx.das.entry.character.Character;
import com.example.jlx.das.entry.character.CharacterReader;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.custom.item.CustomItemView;
import com.example.jlx.das.ui.custom.item.CustomItemViewFactory;


import java.util.Map;

public class CustomView {

    private Context context;
    private LinearLayout mother;
    private String fragmentId;
    private ModeType modeType;


    public CustomView(Context context, LinearLayout mother, String fragementId, ModeType modeType) {
        this.context = context;
        this.mother = mother;
        this.fragmentId = fragementId;
        this.modeType = modeType;
    }

    public void createCustomView(Map<ItemRule,Integer> rules){
        Character fragmentCharacter = CharacterReader.getCharacter(context, fragmentId);
        for(Map.Entry<ItemRule, String> entry : fragmentCharacter.getRuleAndValue().entrySet()){
            ItemRule itemRule = entry.getKey();
            String value = entry.getValue();
            CustomItemView customItemView = CustomItemViewFactory.getCustomItemView(itemRule,value, modeType);
            if(customItemView != null){
                LinearLayout itemView = customItemView.createItemView(context,rules,fragmentCharacter);
                if(itemView != null){
                    mother.addView(itemView);
                }
            }
        }
    }
}
