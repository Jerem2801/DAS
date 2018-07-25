package com.example.jlx.das.ui.item.type.attribute;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jlx.das.R;
import com.example.jlx.das.entry.character.Character;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.item.type.TypeView;
import com.example.jlx.das.ui.item.layout.ItemLayout;
import com.example.jlx.das.ui.item.title.ItemTitle;
import com.example.jlx.das.ui.item.type.attribute.value.AttributeValueView;
import com.example.jlx.das.ui.item.type.attribute.value.AttributeValueViewDisplay;
import com.example.jlx.das.ui.item.type.attribute.value.FocusValueView;
import com.example.jlx.das.ui.item.type.attribute.value.FocusValueViewDisplay;
import com.google.android.flexbox.FlexboxLayout;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class AttributeView extends TypeView {

    private AttributeValueView attributeValueView;
    private FocusValueView focusValueView;



    public AttributeView(ItemRule itemRule, String value) {
        super(itemRule, value);
        attributeValueView = new AttributeValueViewDisplay();
        focusValueView = new FocusValueViewDisplay();
    }

    public void setAttributeValueView(AttributeValueView attributeValueView) {
        this.attributeValueView = attributeValueView;
    }

    public void setFocusValueView(FocusValueView focusValueView) {
        this.focusValueView = focusValueView;
    }

    @Override
    @SuppressLint("NewApi")
    public LinearLayout createItemView(Context context, Map<ItemRule,Integer> rules,Character character,LinearLayout mother){
        LinearLayout itemLayout = null;
        if(isFocus(itemRule)){
            FlexboxLayout flexboxLayout = mother.findViewById(rules.get(itemRule));
            focusValueView.createValueView(context,itemRule,value,rules,character,flexboxLayout);
        }else{
            itemLayout = ItemLayout.createItemLayout(context);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                itemLayout.setBackground(context.getDrawable(R.drawable.custom_border_square_black));
            }

            TextView itemTitle = ItemTitle.getItemTitle(context, itemRule);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                itemTitle.setBackground(context.getResources().getDrawable(R.drawable.custom_border_square_red_with_background));
            }
            itemLayout.addView(itemTitle);

            LinearLayout focusAndValueLayout = attributeValueView.createValueView(context,itemRule,value,rules,character);
            itemLayout.addView(focusAndValueLayout);
        }
        return itemLayout;
    }

    private static boolean isFocus(ItemRule itemRule){
        return StringUtils.contains(itemRule.getId(),"focus");
    }


}
