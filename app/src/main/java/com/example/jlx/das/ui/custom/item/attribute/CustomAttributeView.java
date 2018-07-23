package com.example.jlx.das.ui.custom.item.attribute;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jlx.das.R;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.UiUtils;
import com.example.jlx.das.ui.custom.item.CustomItemView;

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
            attributeValueFocusLinearLayout = createMotherLayout(context);

            TextView attributeView = CustomAttributeNameView.createAttributeTextView(context,itemRule);
            attributeValueFocusLinearLayout.addView(attributeView);

            LinearLayout focusAndValueLayout = CustomFocusAndValueView.createFocusAndValueLayout(context,itemRule,value);
            attributeValueFocusLinearLayout.addView(focusAndValueLayout);
        }
        return attributeValueFocusLinearLayout;
    }

    private static boolean isFocus(ItemRule itemRule){
        return StringUtils.contains(itemRule.getId(),"focus");
    }

    @SuppressLint("NewApi")
    public static LinearLayout createMotherLayout(Context context){
        LinearLayout attributeValueFocusLinearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams attributeValueFocusLinearLayoutparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        attributeValueFocusLinearLayoutparams.setMargins(0,0,0, UiUtils.sizeInDp(context,16));
        attributeValueFocusLinearLayout.setLayoutParams(attributeValueFocusLinearLayoutparams);
        attributeValueFocusLinearLayout.setOrientation(LinearLayout.VERTICAL);
        attributeValueFocusLinearLayout.setBackground(context.getDrawable(R.drawable.custom_border_square_black));
        return attributeValueFocusLinearLayout;
    }

}
