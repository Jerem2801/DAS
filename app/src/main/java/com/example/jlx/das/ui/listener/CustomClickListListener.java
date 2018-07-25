package com.example.jlx.das.ui.listener;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.dialog.helper.DialogFactory;
import com.example.jlx.das.ui.dialog.list.DialogListFactory;
import com.google.android.flexbox.FlexboxLayout;

import java.util.List;

public class CustomClickListListener implements View.OnClickListener {
    private Context context;
    private ItemRule itemRule;
    private FlexboxLayout flexboxLayout;
    private String value;

    public CustomClickListListener(Context context, FlexboxLayout flexboxLayout, ItemRule itemRule, String value){
        this.context = context;
        this.itemRule = itemRule;
        this.flexboxLayout = flexboxLayout;
        this.value = value;
    }

    @Override
    public void onClick(View v) {
        Dialog dialog = DialogListFactory.createCustomDialog(context,flexboxLayout,itemRule,value);
        dialog.show();
    }
}
