package com.example.jlx.das.ui.custom.item.normal;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TextView;

import com.example.jlx.das.R;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.listener.CustomClickHelpListener;

import org.apache.commons.lang3.StringUtils;

public class CustomNormalTitleView {

    public TextView createTitleView(Context context, ItemRule itemRule) {
        TextView textTitle = new TextView(context);
        textTitle.setText(itemRule.getName());
        textTitle.setTextColor(context.getResources().getColor(R.color.colorWhite));
        textTitle.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        textTitle.setGravity(Gravity.CENTER);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            textTitle.setBackground(context.getResources().getDrawable(R.drawable.custom_border_red_with_background));
        }
        if(StringUtils.isNotBlank(itemRule.getDescription())) {
            textTitle.setOnClickListener(new CustomClickHelpListener(context, itemRule.getName(), itemRule.getDescription()));
        }
        return textTitle;
    }
}
