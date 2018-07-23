package com.example.jlx.das.ui.custom.item.attribute;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jlx.das.R;
import com.example.jlx.das.entry.ValueUtils;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.UiUtils;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayout;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Text;

public class CustomFocusAndValueView {

    private CustomFocusAndValueView(){

    }
    public static LinearLayout createFocusAndValueLayout(Context context, ItemRule itemRule, String value) {
        // LINEAR HORIZONTAL
        LinearLayout motherLayout = createMotherLayout(context);

        // FLEX BOX
        FlexboxLayout flex = createFlexLayout(context);
        motherLayout.addView(flex);

        // VALUE
        TextView valueLinearLayout = createValueLinearLayout(context,value);
        motherLayout.addView(valueLinearLayout);

        return motherLayout;
    }

    private static LinearLayout createMotherLayout(Context context){
        LinearLayout linearHorizon = new LinearLayout(context);
        LinearLayout.LayoutParams linearHorizonParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linearHorizon.setLayoutParams(linearHorizonParams);
        linearHorizon.setOrientation(LinearLayout.HORIZONTAL);
        return linearHorizon;
    }

    private static TextView createValueLinearLayout(Context context,String value) {
        TextView valueView =  new TextView(context);
        LinearLayout.LayoutParams attributeFocusLinearLayoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
        attributeFocusLinearLayoutParams.weight = 0.5f;
        attributeFocusLinearLayoutParams.setMargins(0,  0, 0,0);
        valueView.setLayoutParams(attributeFocusLinearLayoutParams);
        valueView.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
        valueView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        valueView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        valueView.setText("0");
        if(!ValueUtils.isEmpty(value)){
            valueView.setText(value);
        }
        valueView.setGravity(Gravity.CENTER);


        return valueView;
    }



    private static FlexboxLayout createFlexLayout(Context context) {
        FlexboxLayout flexboxLayout = new FlexboxLayout(context);
        flexboxLayout.setFlexWrap(FlexWrap.WRAP);
        LinearLayout.LayoutParams focusParam = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
        focusParam.weight = 1.5f;
        focusParam.setMargins(0,  0, 0,0);
        flexboxLayout.setLayoutParams(focusParam);

        /*
        if(flexboxLayout.getChildAt(0) == null){
            TextView focusView = new TextView(context);
            FlexboxLayout.LayoutParams focusParams = new FlexboxLayout.LayoutParams(FlexboxLayout.LayoutParams.WRAP_CONTENT, FlexboxLayout.LayoutParams.WRAP_CONTENT);
            focusParams.setMargins(UiUtils.sizeInDp(context,4),  UiUtils.sizeInDp(context,4), UiUtils.sizeInDp(context,4),UiUtils.sizeInDp(context,4));
            focusView.setLayoutParams(focusParams);
            focusView.setText("NONE");
            focusView.setVisibility(View.INVISIBLE);
            flexboxLayout.addView(focusView);
        }*/


        return flexboxLayout;
    }
}
