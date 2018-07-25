package com.example.jlx.das.ui.item.type.attribute.value;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;

import com.example.jlx.das.R;
import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.ui.UiUtils;
import com.example.jlx.das.ui.listener.CustomClickHelpListener;
import com.google.android.flexbox.FlexboxLayout;

public class Focus {

    private Focus(){

    }

    @SuppressLint("NewApi")
    public static TextView createFocusList(Context context, Item item) {
        TextView focusView = new TextView(context);
        FlexboxLayout.LayoutParams focusParams = new FlexboxLayout.LayoutParams(FlexboxLayout.LayoutParams.WRAP_CONTENT, FlexboxLayout.LayoutParams.WRAP_CONTENT);
        focusParams.setMargins(UiUtils.sizeInDp(context,4),  UiUtils.sizeInDp(context,4), UiUtils.sizeInDp(context,4),UiUtils.sizeInDp(context,4));
        focusView.setLayoutParams(focusParams);
        String name = item.getName();
        focusView.setText(name);
        focusView.setBackground(context.getDrawable(R.drawable.custom_border_round_black));
        focusView.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
        focusView.setOnClickListener(new CustomClickHelpListener(context,item.getName(),item.getDescription()));
        return focusView;
    }
}
