package com.example.jlx.das.entry.character;

import android.view.View;

import com.example.jlx.das.entry.rule.ItemRule;

import java.util.Map;

public class CharacterEdit {

    public Map<ItemRule,View> ruleAndView;

    public CharacterEdit(Map<ItemRule, View> ruleAndView) {
        this.ruleAndView = ruleAndView;
    }

    public Map<ItemRule, View> getRuleAndView() {
        return ruleAndView;
    }

    public void setRuleAndView(Map<ItemRule, View> ruleAndView) {
        this.ruleAndView = ruleAndView;
    }

}
