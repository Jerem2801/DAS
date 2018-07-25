package com.example.jlx.das.ui.item.type.normal;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jlx.das.R;
import com.example.jlx.das.entry.character.Character;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.item.type.TypeView;
import com.example.jlx.das.ui.item.type.normal.value.NormalValueViewDisplay;
import com.example.jlx.das.ui.item.type.normal.value.NormalValueView;
import com.example.jlx.das.ui.item.layout.ItemLayout;
import com.example.jlx.das.ui.item.title.ItemTitle;

import java.util.Map;


public class NormalView extends TypeView {

    private NormalValueView normalValueView;

    public NormalView(ItemRule rule, String value) {
        super(rule,value);
        this.normalValueView = new NormalValueViewDisplay();
    }


    public void setNormalValueView(NormalValueView normalValueView) {
        this.normalValueView = normalValueView;
    }

    @Override
    @SuppressLint("NewApi")
    public LinearLayout createItemView(Context context, Map<ItemRule,Integer> rules,Character character,LinearLayout mother){
        LinearLayout itemLayout = ItemLayout.createItemLayout(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            itemLayout.setBackground(context.getResources().getDrawable(R.drawable.custom_border_round_black));
        }

        TextView itemTitle = ItemTitle.getItemTitle(context, itemRule);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            itemTitle.setBackground(context.getResources().getDrawable(R.drawable.custom_border_round_red_with_background));
        }
        itemLayout.addView(itemTitle);

        View valueView = normalValueView.createValueView(context,itemRule,value,rules);
        itemLayout.addView(valueView);

        return itemLayout;
    }
}
