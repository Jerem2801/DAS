package com.example.jlx.das.ui.custom.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.example.jlx.das.entry.character.CharacterDisplay;
import com.example.jlx.das.entry.character.CharacterEdit;
import com.example.jlx.das.entry.character.CharacterReader;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.custom.item.CustomItemView;
import com.example.jlx.das.ui.custom.item.CustomItemViewFactory;


import java.util.Map;

public class CustomView {

    private Context context;
    private LinearLayout mother;
    private String fragmentId;
    private String mode;


    public CustomView(Context context, LinearLayout mother, String fragementId, String mode) {
        this.context = context;
        this.mother = mother;
        this.fragmentId = fragementId;
        this.mode = mode;
    }

    public void createCustomView(Map<Integer,ItemRule> test){
        CharacterDisplay fragmentCharacterDisplay = CharacterReader.getCharacter(context, fragmentId);
        for(Map.Entry<ItemRule, String> entry : fragmentCharacterDisplay.getRuleAndValue().entrySet()){
            ItemRule itemRule = entry.getKey();
            String value = entry.getValue();
            CustomItemView customItemView = CustomItemViewFactory.getCustomItemView(itemRule,value,mode);
            if(customItemView != null){
                LinearLayout itemView = customItemView.createItemView(context,test);
                mother.addView(itemView);
            }
        }
    }
}
