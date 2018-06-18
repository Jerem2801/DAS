package com.example.jlx.das.ui.listener;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.ui.dialog.DialogFactory;

import java.util.zip.Inflater;

public class CustomClickHelpListener implements View.OnClickListener{

    private Context context;
    private String title;
    private String value;

    public CustomClickHelpListener(Context context, String title, String value){
        this.context = context;
        this.title = title;
        this.value = value;
    }

    @Override
    public void onClick(View v) {
        LayoutInflater inflater = LayoutInflater.from(context);
        Dialog dialog = DialogFactory.createCustomDialog(context,inflater, title, value);
        dialog.show();
    }


}
