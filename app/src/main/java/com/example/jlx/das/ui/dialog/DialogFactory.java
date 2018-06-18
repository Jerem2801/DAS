package com.example.jlx.das.ui.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.text.Layout;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jlx.das.R;
import com.example.jlx.das.ui.UiUtils;

public class DialogFactory {

    private DialogFactory(){

    }

    public static Dialog createCustomDialog(Context context, LayoutInflater inflater, String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View inflate = inflater.inflate(R.layout.dialog_help, null);
        LinearLayout linear = (LinearLayout) inflate;

        TextView titleView =  new TextView(context);
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
        titleView.setText(title);
        titleView.setGravity(Gravity.CENTER);
        linear.addView(titleView);

        TextView descView =  new TextView(context);
        LinearLayout.LayoutParams descViewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        descViewParams.setMargins(UiUtils.sizeInDp(context,16),  UiUtils.sizeInDp(context,16), UiUtils.sizeInDp(context,16),UiUtils.sizeInDp(context,16));
        descView.setLayoutParams(descViewParams);
        message = message.substring(0, 1).toUpperCase() + message.substring(1);
        descView.setText(message);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            descView.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        }

        linear.addView(descView);


        builder.setView(inflate);
        AlertDialog dialog = builder.create();
        return dialog;
    }
}
