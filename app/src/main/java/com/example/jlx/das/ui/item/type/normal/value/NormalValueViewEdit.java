package com.example.jlx.das.ui.item.type.normal.value;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.jlx.das.data.DataPoolManager;
import com.example.jlx.das.entry.ValueUtils;
import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.UiUtils;
import com.example.jlx.das.ui.item.view.IdUtils;
import com.example.jlx.das.ui.spinner.SpinnerUtils;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class NormalValueViewEdit implements NormalValueView {

    @Override
    public View createValueView(Context context,ItemRule itemRule, String value,Map<ItemRule,Integer> rules) {
        View view = null;
        if(StringUtils.equals(itemRule.getTypeValue(),"id")){
            String reference = itemRule.getReference();
            List<Item> items = DataPoolManager.getItems(reference);
            Item item = DataPoolManager.getItem(reference,value);
            Spinner spinner = SpinnerUtils.createSpinnerWithItem(context,items,item);
            view = spinner;
        }else{
            EditText textValue = new EditText(context);
            if(ValueUtils.isEmpty(value)){
                value = StringUtils.EMPTY;
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.MATCH_PARENT);
            params.gravity = Gravity.CENTER;
            textValue.setLayoutParams(params);
            textValue.setText(value);
            textValue.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textValue.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            textValue.setGravity(Gravity.CENTER);
            view = textValue;
        }
        view.setPadding(UiUtils.sizeInDp(context,6),UiUtils.sizeInDp(context,6),UiUtils.sizeInDp(context,6),UiUtils.sizeInDp(context,6));
        IdUtils.setIdToView(view,itemRule,rules);
        return view;
    }


}
