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
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.UiUtils;
import com.example.jlx.das.ui.custom.item.CustomItemView;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayout;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class CustomAttributeView extends CustomItemView {


    public CustomAttributeView(ItemRule itemRule, String value) {
        super(itemRule, value);
    }

    @Override
    @SuppressLint("NewApi")
    public LinearLayout createItemView(Context context, Map<ItemRule,Integer> rules){
        LinearLayout attributeValueFocusLinearLayout = null;
        if(isFocus(itemRule)){

        }else{
            attributeValueFocusLinearLayout = new LinearLayout(context);
            LinearLayout.LayoutParams attributeValueFocusLinearLayoutparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            attributeValueFocusLinearLayoutparams.setMargins(0,  UiUtils.sizeInDp(context,8), 0,0);
            attributeValueFocusLinearLayout.setLayoutParams(attributeValueFocusLinearLayoutparams);
            attributeValueFocusLinearLayout.setBackground(context.getResources().getDrawable(R.drawable.custom_border_black));
            attributeValueFocusLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

            LinearLayout attributeAndFocusLinearLayout = createAttributeAndFocusLinearLayout(context);

            TextView attributeNameView = createAttributeNameView(context);
            attributeAndFocusLinearLayout.addView(attributeNameView);

            FlexboxLayout focusView = createFocusView(context);
            attributeAndFocusLinearLayout.addView(focusView);

            attributeValueFocusLinearLayout.addView(attributeAndFocusLinearLayout);
        }
        return attributeValueFocusLinearLayout;
    }

    private static boolean isFocus(ItemRule itemRule){
        return StringUtils.contains(itemRule.getId(),"focus");
    }

    private LinearLayout createAttributeAndFocusLinearLayout(Context context) {
        LinearLayout attributeFocusLinearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams attributeFocusLinearLayoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
        attributeFocusLinearLayoutParams.weight = 1.5f;
        attributeFocusLinearLayout.setLayoutParams(attributeFocusLinearLayoutParams);
        attributeFocusLinearLayout.setOrientation(LinearLayout.VERTICAL);
        return attributeFocusLinearLayout;
    }

    @SuppressLint("NewApi")
    private TextView createAttributeNameView(Context context){
        TextView attributeNameView =  new TextView(context);
        LinearLayout.LayoutParams attributeNameParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        attributeNameView.setPadding(UiUtils.sizeInDp(context,2),  UiUtils.sizeInDp(context,2), UiUtils.sizeInDp(context,2),UiUtils.sizeInDp(context,2));
        attributeNameView.setLayoutParams(attributeNameParams);
        setAttributeName(attributeNameView);
        attributeNameView.setText(itemRule.getName());
        attributeNameView.setGravity(Gravity.CENTER);
        //attributeNameView.setBackground(context.getResources().getDrawable(R.drawable.custom_border_attribute));
        return attributeNameView;
    }

    public static void setAttributeName(TextView textView){
        Context context = textView.getContext();
        textView.setTextColor(context.getResources().getColor(R.color.colorAccent));
        textView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        textView.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
    }

    @SuppressLint("NewApi")
    private FlexboxLayout createFocusView(Context context) {
        FlexboxLayout flexboxLayout = new FlexboxLayout(context);
        flexboxLayout.setFlexWrap(FlexWrap.WRAP);
        LinearLayout.LayoutParams focusParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        focusParam.setMargins(0,  0, 0,0);
        flexboxLayout.setLayoutParams(focusParam);

        return flexboxLayout;
    }

}
