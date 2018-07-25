package com.example.jlx.das.entry.character;

import com.example.jlx.das.entry.rule.ItemRule;

import org.apache.commons.lang3.StringUtils;

public class CharacterManager {

    private CharacterManager(){

    }

    public static ItemRule getItemRuleFromId(Character character,String id){
        ItemRule itemRule = null;
        for(ItemRule rule : character.getRuleAndValue().keySet()){
            if(StringUtils.equals(rule.getId(),id)){
                itemRule = rule;
            }
        }
        return itemRule;
    }
}
