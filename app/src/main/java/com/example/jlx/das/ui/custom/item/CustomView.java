package com.example.jlx.das.ui.custom.item;

import android.content.Context;
import android.widget.LinearLayout;

import com.example.jlx.das.entry.character.Character;
import com.example.jlx.das.entry.character.CharacterReader;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.custom.view.CustomItemView;
import com.example.jlx.das.ui.custom.view.CustomItemViewFactory;


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

    public void createCustomView(){
        Character fragmentCharacter = CharacterReader.getCharacter(context, fragmentId);
        for(Map.Entry<ItemRule, String> entry : fragmentCharacter.getRuleAndValue().entrySet()){
            ItemRule itemRule = entry.getKey();
            String value = entry.getValue();
            CustomItemView customItemView = CustomItemViewFactory.getCustomItemView(itemRule,value,mode);
            LinearLayout itemView = customItemView.createItemView(context);
            mother.addView(itemView);
        }
    }
}
