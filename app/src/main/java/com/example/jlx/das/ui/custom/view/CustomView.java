package com.example.jlx.das.ui.custom.view;

import android.content.Context;
import android.widget.LinearLayout;

import com.example.jlx.das.controller.fragment.ModeFragment;
import com.example.jlx.das.entry.character.CharacterDisplay;
import com.example.jlx.das.entry.character.CharacterReader;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.custom.item.CustomItemView;
import com.example.jlx.das.ui.custom.item.CustomItemViewFactory;


import java.util.Map;

public class CustomView {

    private Context context;
    private LinearLayout mother;
    private String fragmentId;
    private ModeFragment modeFragment;


    public CustomView(Context context, LinearLayout mother, String fragementId, ModeFragment modeFragment) {
        this.context = context;
        this.mother = mother;
        this.fragmentId = fragementId;
        this.modeFragment = modeFragment;
    }

    public void createCustomView(Map<Integer,ItemRule> test){
        CharacterDisplay fragmentCharacterDisplay = CharacterReader.getCharacter(context, fragmentId);
        for(Map.Entry<ItemRule, String> entry : fragmentCharacterDisplay.getRuleAndValue().entrySet()){
            ItemRule itemRule = entry.getKey();
            String value = entry.getValue();
            CustomItemView customItemView = CustomItemViewFactory.getCustomItemView(itemRule,value, modeFragment);
            if(customItemView != null){
                LinearLayout itemView = customItemView.createItemView(context,test);
                mother.addView(itemView);
            }
        }
    }
}
