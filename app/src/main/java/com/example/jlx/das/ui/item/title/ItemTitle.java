package com.example.jlx.das.ui.item.title;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TextView;

import com.example.jlx.das.R;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.listener.CustomClickHelpListener;

import org.apache.commons.lang3.StringUtils;

public class ItemTitle {

    private ItemTitle(){

    }

    public static TextView getItemTitle(Context context, ItemRule itemRule){
        TextView itemTitle = new TextView(context);
        itemTitle.setText(itemRule.getName());
        itemTitle.setTextColor(context.getResources().getColor(R.color.colorWhite));
        itemTitle.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        itemTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        itemTitle.setGravity(Gravity.CENTER);
        if(StringUtils.isNotBlank(itemRule.getDescription())) {
            itemTitle.setOnClickListener(new CustomClickHelpListener(context, itemRule.getName(), itemRule.getDescription()));
        }
        return itemTitle;

    }
}
