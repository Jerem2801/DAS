package com.example.jlx.das.entry.character.save;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.stream.RessourceUtils;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class SaveAction {

    private SaveAction(){

    }

    public static boolean save(Context context, String fragmentId, LinearLayout linearMother,Map<Integer,ItemRule> valueViewId){
        boolean succes = true;
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<Integer, ItemRule> entry : valueViewId.entrySet()){
            Integer key = entry.getKey();
            ItemRule itemRule = entry.getValue();
            View viewById = linearMother.findViewById(key);
            if(StringUtils.equals(itemRule.getTypeValue(),"custom")){
                EditText text = (EditText) viewById;
                if(text != null){
                    builder.append(itemRule.getId()+";"+text.getText().toString());
                }
            }else{
                Spinner spinner = (Spinner) viewById;
                Item item = (Item) spinner.getSelectedItem();
                if(item != null){
                    builder.append(itemRule.getId()+";"+item.getId());
                }
            }
            builder.append("\n");
        }
        RessourceUtils.writeFile(context,fragmentId + ".csv",builder.toString());
        return succes;
    }
}
