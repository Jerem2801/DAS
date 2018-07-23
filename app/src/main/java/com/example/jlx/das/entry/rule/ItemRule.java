package com.example.jlx.das.entry.rule;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.example.jlx.das.entry.item.Item;

import java.util.Comparator;

public class ItemRule extends Item {

    private int order;
    private String typeView;
    private String typeValue;
    private String reference;
    private String rule;
    private String ruleValue;

    public ItemRule(String id, String name, String description, int order, String typeView, String typeValue, String reference, String rule, String ruleValue) {
        super(id, name, description);
        this.order = order;
        this.typeView = typeView;
        this.typeValue = typeValue;
        this.reference = reference;
        this.rule = rule;
        this.ruleValue = ruleValue;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTypeView() {
        return typeView;
    }

    public void setTypeView(String typeView) {
        this.typeView = typeView;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getRuleValue() {
        return ruleValue;
    }

    public void setRuleValue(String ruleValue) {
        this.ruleValue = ruleValue;
    }
}
