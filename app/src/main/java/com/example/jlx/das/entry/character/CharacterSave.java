package com.example.jlx.das.entry.character;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.jlx.das.data.DataPoolReader;
import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.stream.RessourceUtils;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class CharacterSave {

    private CharacterSave(){

    }

    public static boolean save(Context context, String fragmentId, LinearLayout linearMother,Map<ItemRule,Integer> valueViewId){
        boolean succes = true;

        Character character = CharacterReader.getCharacterNewValue(linearMother,valueViewId);

        String content = getContent(character);

        RessourceUtils.writeFile(context,fragmentId + DataPoolReader.CSV ,content);

        return succes;
    }

    private static String getContent(Character character){
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<ItemRule, String> entry : character.getRuleAndValue().entrySet()){
            ItemRule itemRule = entry.getKey();
            String value = entry.getValue();
            if(!StringUtils.isBlank(value)){
                builder.append(itemRule.getId()+";"+value);
                builder.append("\n");
            }

        }
        return builder.toString();
    }


}
