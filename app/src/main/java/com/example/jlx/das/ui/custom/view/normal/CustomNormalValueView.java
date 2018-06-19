package com.example.jlx.das.ui.custom.view.normal;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TextView;

import com.example.jlx.das.data.DataPoolManager;
import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.custom.view.CustomValueView;
import com.example.jlx.das.ui.listener.CustomClickHelpListener;

import org.apache.commons.lang3.StringUtils;

public class CustomNormalValueView implements CustomValueView {

    @Override
    public TextView createValueView(Context context, ItemRule itemRule, String value) {
        TextView textValue = new TextView(context);
        if(StringUtils.equals(itemRule.getTypeValue(),"id")){
            String reference = itemRule.getReference();
            Item item = DataPoolManager.getItem(reference, value);
            value = item.getName();
            textValue.setOnClickListener(new CustomClickHelpListener(context,value,item.getDescription()));
        }
        textValue.setText(value);
        textValue.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textValue.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        textValue.setGravity(Gravity.CENTER);
        return textValue;
    }
}
