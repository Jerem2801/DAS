package com.example.jlx.das.ui.custom.item.normal;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.jlx.das.data.DataPoolManager;
import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.UiUtils;
import com.example.jlx.das.ui.custom.item.CustomValueView;
import com.example.jlx.das.ui.spinner.SpinnerUtils;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class CustomNormalValueEditView implements CustomValueView {

    @Override
    public View createValueView(Context context,ItemRule itemRule, String value) {
        View view = null;
        if(StringUtils.equals(itemRule.getTypeValue(),"id")){
            String reference = itemRule.getReference();
            List<Item> items = DataPoolManager.getItems(reference);
            Item item = DataPoolManager.getItem(reference,value);
            Spinner spinner = SpinnerUtils.createSpinnerWithItem(context,items,item);
            view = spinner;
        }else{
            EditText textValue = new EditText(context);
            textValue.setText(value);
            textValue.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textValue.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            textValue.setGravity(Gravity.CENTER);
            view = textValue;
        }

        return view;
    }


}
