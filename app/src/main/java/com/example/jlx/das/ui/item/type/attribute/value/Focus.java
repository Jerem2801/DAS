package com.example.jlx.das.ui.item.type.attribute.value;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
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
    public static TextView createFocusList(Context context, Item item,String separator) {
        TextView focusView = new TextView(context);
        FlexboxLayout.LayoutParams focusParams = new FlexboxLayout.LayoutParams(FlexboxLayout.LayoutParams.WRAP_CONTENT, FlexboxLayout.LayoutParams.WRAP_CONTENT);
        focusParams.setMargins(UiUtils.sizeInDp(context,6),  UiUtils.sizeInDp(context,2), UiUtils.sizeInDp(context,6),UiUtils.sizeInDp(context,2));
        focusView.setLayoutParams(focusParams);
        String name = item.getName();
        focusView.setText(name+separator);
        focusView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        focusView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
        focusView.setTextColor(context.getResources().getColor(R.color.colorAccent));
        focusView.setOnClickListener(new CustomClickHelpListener(context,item.getName(),item.getDescription()));
        return focusView;
    }
}
