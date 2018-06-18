package com.example.jlx.das.entry.character;

import com.example.jlx.das.entry.rule.ItemRule;

import java.util.Map;

public class Character {

    public Map<ItemRule,String> ruleAndValue;

    public Character(Map<ItemRule, String> ruleAndValue) {
        this.ruleAndValue = ruleAndValue;
    }

    public Map<ItemRule, String> getRuleAndValue() {
        return ruleAndValue;
    }

    public void setRuleAndValue(Map<ItemRule, String> ruleAndValue) {
        this.ruleAndValue = ruleAndValue;
    }


}
