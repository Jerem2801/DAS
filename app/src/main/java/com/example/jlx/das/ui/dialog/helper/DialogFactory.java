package com.example.jlx.das.ui.dialog.helper;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.jlx.das.R;

public class DialogFactory {

    private DialogFactory(){

    }

    public static Dialog createCustomDialog(Context context, LayoutInflater inflater, String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View inflate = inflater.inflate(R.layout.dialog_help, null);
        ScrollView scrollView = (ScrollView) inflate;
        LinearLayout linearLayout = new LinearLayout(context);
        ScrollView.LayoutParams linearParams = new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT, ScrollView.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(linearParams);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(linearLayout);

        TextView titleView = DialogTitle.createTitleDialog(context,title);
        linearLayout.addView(titleView);

        LinearLayout dialogDescription = DialogDescription.createDialogDescription(context, message);
        linearLayout.addView(dialogDescription);

        builder.setView(inflate);
        AlertDialog dialog = builder.create();
        return dialog;
    }
}
