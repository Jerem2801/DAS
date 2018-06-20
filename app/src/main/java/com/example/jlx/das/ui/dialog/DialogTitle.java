package com.example.jlx.das.ui.dialog;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jlx.das.R;
import com.example.jlx.das.ui.UiUtils;

public class DialogTitle {
    private DialogTitle(){

    }

    public static TextView createTitleDialog(Context context, String titleText){
        TextView titleView = new TextView(context);
        LinearLayout.LayoutParams titleViewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, UiUtils.sizeInDp(context,35));
        titleView.setLayoutParams(titleViewParams);
        titleView.setTextColor(context.getResources().getColor(R.color.colorWhite));
        titleView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        titleView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            titleView.setBackground(context.getResources().getDrawable(R.drawable.custom_background_radiant));
        }else{
            titleView.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        }
        titleView.setText(titleText);
        titleView.setGravity(Gravity.CENTER);
        return titleView;
    }
}
