package com.example.jlx.das.entry.rule;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.example.jlx.das.entry.item.Item;

import java.util.Comparator;

public class ItemRule extends Item {

    private int order;
    private String typeValue;
    private String reference;

    public ItemRule(String id, String name, String description, int order, String typeValue, String reference) {
        super(id, name, description);
        this.order = order;
        this.typeValue = typeValue;
        this.reference = reference;
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


}
