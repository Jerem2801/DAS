package com.example.jlx.das.ui.custom.item.attribute;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jlx.das.R;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.listener.CustomClickHelpListener;

import org.apache.commons.lang3.StringUtils;

public class CustomAttributeNameView {

    private CustomAttributeNameView(){

    }

    @SuppressLint("NewApi")
    public static TextView createAttributeTextView(Context context, ItemRule itemRule) {
        TextView attributeName = new TextView(context);
        attributeName.setText(itemRule.getName());
        attributeName.setTextColor(context.getResources().getColor(R.color.colorWhite));
        attributeName.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        attributeName.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        attributeName.setGravity(Gravity.CENTER);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            attributeName.setBackground(context.getResources().getDrawable(R.drawable.custom_border_square_red_with_background));
        }
        if(StringUtils.isNotBlank(itemRule.getDescription())) {
            attributeName.setOnClickListener(new CustomClickHelpListener(context, itemRule.getName(), itemRule.getDescription()));
        }
        return attributeName;
    }

}
