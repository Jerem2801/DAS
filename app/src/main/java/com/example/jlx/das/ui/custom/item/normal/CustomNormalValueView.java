package com.example.jlx.das.ui.custom.item.normal;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jlx.das.data.DataPoolManager;
import com.example.jlx.das.entry.ValueUtils;
import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.UiUtils;
import com.example.jlx.das.ui.custom.item.CustomValueView;
import com.example.jlx.das.ui.listener.CustomClickHelpListener;

import org.apache.commons.lang3.StringUtils;

public class CustomNormalValueView implements CustomValueView {

    @Override
    public View createValueView(Context context, ItemRule itemRule, String value) {
        TextView textValue = new TextView(context);
        if(ValueUtils.isEmpty(value)){
            textValue.setVisibility(View.INVISIBLE);
        }else if(StringUtils.equals(itemRule.getTypeValue(),"id")){
            String reference = itemRule.getReference();
            Item item = DataPoolManager.getItem(reference, value);
            value = item.getName();
            if(StringUtils.isNotBlank(item.getDescription())) {
                textValue.setOnClickListener(new CustomClickHelpListener(context, value, item.getDescription()));
            }
        }
        textValue.setPadding(UiUtils.sizeInDp(context,6),UiUtils.sizeInDp(context,6),UiUtils.sizeInDp(context,6),UiUtils.sizeInDp(context,6));
        textValue.setText(value);
        textValue.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textValue.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        textValue.setGravity(Gravity.CENTER);
        return textValue;
    }
}
