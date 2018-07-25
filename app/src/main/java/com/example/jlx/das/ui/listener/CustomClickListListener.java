package com.example.jlx.das.ui.listener;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.ui.dialog.helper.DialogFactory;
import com.example.jlx.das.ui.dialog.list.DialogListFactory;
import com.google.android.flexbox.FlexboxLayout;

import java.util.List;

public class CustomClickListListener implements View.OnClickListener {
    private Context context;
    private String title;
    private List<Item> items;
    private FlexboxLayout flexboxLayout;

    public CustomClickListListener(Context context, String title, List<Item> items,FlexboxLayout flexboxLayout){
        this.context = context;
        this.title = title;
        this.items = items;
        this.flexboxLayout = flexboxLayout;
    }

    @Override
    public void onClick(View v) {
        //LayoutInflater inflater = LayoutInflater.from(context);
        Dialog dialog = DialogListFactory.createCustomDialog(context,title,items,flexboxLayout);
        dialog.show();
    }
}
