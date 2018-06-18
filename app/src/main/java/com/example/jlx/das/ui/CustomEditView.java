package com.example.jlx.das.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jlx.das.R;
import com.example.jlx.das.data.DataPoolManager;
import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.listener.CustomClickHelpListener;

import org.apache.commons.lang3.StringUtils;

public class CustomEditView {

    private Context context;
    private LinearLayout mother;
    private ItemRule itemRule;
    private String value;


    public CustomEditView(Context context, LinearLayout mother, ItemRule itemRule, String value) {
        this.context = context;
        this.mother = mother;
        this.itemRule = itemRule;
        this.value = value;
    }

    public void createCustomCataView(){
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linearParams.setMargins(0,0,0,UiUtils.sizeInDp(context,16));
        linearLayout.setLayoutParams(linearParams);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            linearLayout.setBackground(context.getResources().getDrawable(R.drawable.custom_border_black));
        }
        mother.addView(linearLayout);

        TextView textTitle = new TextView(context);
        textTitle.setText(itemRule.getName());
        textTitle.setTextColor(context.getResources().getColor(R.color.colorWhite));
        textTitle.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        textTitle.setGravity(Gravity.CENTER);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            textTitle.setBackground(context.getResources().getDrawable(R.drawable.custom_border_red_with_background));
        }
        textTitle.setOnClickListener(new CustomClickHelpListener(context,itemRule.getName(),itemRule.getDescription()));
        linearLayout.addView(textTitle);

        EditText textValue = new EditText(context);
        if(StringUtils.equals(itemRule.getTypeValue(),"id")){
            String reference = itemRule.getReference();
            Item item = DataPoolManager.getItem(reference, value);
            value = item.getName();
        }
        textValue.setText(value);
        textValue.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textValue.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        textValue.setGravity(Gravity.CENTER);
        linearLayout.addView(textValue);
    }
}
