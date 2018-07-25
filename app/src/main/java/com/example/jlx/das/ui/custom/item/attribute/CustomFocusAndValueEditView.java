package com.example.jlx.das.ui.custom.item.attribute;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jlx.das.R;
import com.example.jlx.das.entry.ValueUtils;
import com.example.jlx.das.entry.character.Character;
import com.example.jlx.das.entry.character.CharacterManager;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.UiUtils;
import com.example.jlx.das.ui.custom.view.IdUtils;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayout;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class CustomFocusAndValueEditView implements CustomFocusValueView{

    private static final String FOCUS = "_focus";

    public CustomFocusAndValueEditView(){

    }

    @SuppressLint("NewApi")
    public LinearLayout createValueView(Context context, ItemRule itemRule, String value, Map<ItemRule,Integer> rules, Character character) {
        // LINEAR HORIZONTAL
        LinearLayout motherLayout = createMotherLayout(context);

        // FLEX BOX
        FlexboxLayout flex = createFlexLayout(context);
        motherLayout.addView(flex);
        String id = itemRule.getId() + FOCUS;
        ItemRule itemRuleFocus = CharacterManager.getItemRuleFromId(character, id);
        IdUtils.setIdToView(flex,itemRuleFocus,rules);

        // VALUE
        EditText textValue = new EditText(context);
        if(ValueUtils.isEmpty(value)){
            value = StringUtils.EMPTY;
        }
        LinearLayout.LayoutParams attributeFocusLinearLayoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
        attributeFocusLinearLayoutParams.weight = 0.5f;
        attributeFocusLinearLayoutParams.gravity = Gravity.CENTER;
        textValue.setLayoutParams(attributeFocusLinearLayoutParams);
        textValue.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
        textValue.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textValue.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        textValue.setText("0");
        if(ValueUtils.isEmpty(value) || !StringUtils.isEmpty(value)){
            textValue.setText(value);
        }
        textValue.setBackground(context.getDrawable(R.drawable.custom_line_vertical));
        textValue.setGravity(Gravity.CENTER);

        motherLayout.addView(textValue);
        IdUtils.setIdToView(textValue,itemRule,rules);


        return motherLayout;
    }


    private LinearLayout createMotherLayout(Context context){
        LinearLayout linearHorizon = new LinearLayout(context);
        LinearLayout.LayoutParams linearHorizonParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linearHorizon.setLayoutParams(linearHorizonParams);
        linearHorizon.setOrientation(LinearLayout.HORIZONTAL);
        return linearHorizon;
    }

    @SuppressLint("NewApi")
    private TextView createValueLinearLayout(Context context, String value) {
        TextView valueView =  new TextView(context);
        LinearLayout.LayoutParams attributeFocusLinearLayoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
        attributeFocusLinearLayoutParams.weight = 0.5f;
        //attributeFocusLinearLayoutParams.setMargins(0,  0, 0,0);
        valueView.setLayoutParams(attributeFocusLinearLayoutParams);
        valueView.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
        valueView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        valueView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        valueView.setText("0");
        if(!ValueUtils.isEmpty(value)){
            valueView.setText(value);
        }
        valueView.setBackground(context.getDrawable(R.drawable.custom_line_vertical));
        valueView.setGravity(Gravity.CENTER);


        return valueView;
    }


    private FlexboxLayout createFlexLayout(Context context) {
        FlexboxLayout flexboxLayout = new FlexboxLayout(context);
        flexboxLayout.setFlexWrap(FlexWrap.WRAP);
        LinearLayout.LayoutParams focusParam = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
        focusParam.weight = 1.5f;
        focusParam.setMargins(0,  0, 0,0);
        flexboxLayout.setLayoutParams(focusParam);


        if(flexboxLayout.getChildAt(0) == null){
            TextView focusView = new TextView(context);
            FlexboxLayout.LayoutParams focusParams = new FlexboxLayout.LayoutParams(FlexboxLayout.LayoutParams.WRAP_CONTENT, FlexboxLayout.LayoutParams.WRAP_CONTENT);
            focusParams.setMargins(UiUtils.sizeInDp(context,4),  UiUtils.sizeInDp(context,4), UiUtils.sizeInDp(context,4),UiUtils.sizeInDp(context,4));
            focusView.setLayoutParams(focusParams);
            focusView.setText("NONE");
            focusView.setVisibility(View.INVISIBLE);
            flexboxLayout.addView(focusView);
        }


        return flexboxLayout;
    }

}
