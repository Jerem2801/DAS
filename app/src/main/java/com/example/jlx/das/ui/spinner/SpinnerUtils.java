package com.example.jlx.das.ui.spinner;

import android.content.Context;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.jlx.das.R;
import com.example.jlx.das.entry.item.Item;

import java.util.List;

public class SpinnerUtils {

    private SpinnerUtils(){

    }

    public static Spinner createSpinner(Context context,List<Item> items){
        Spinner spinner = new Spinner(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        spinner.setLayoutParams(params);
        spinner.setGravity(Gravity.CENTER);
        SpinnerUtils.setSpinnerItem(context,spinner,items);
        return spinner;
    }

    public static Spinner createSpinnerWithItem(Context context,List<Item> items,Item item){
        Spinner spinner = createSpinner(context,items);
        int position = getPositionOnItem(spinner,item);
        spinner.setSelection(position);
        return spinner;
    }


    private static void setSpinnerItem(Context context, Spinner spinner, List<Item> items) {
        ArrayAdapter<Item> adapter = new ArrayAdapter<>(context.getApplicationContext(), R.layout.custom_spinner, items);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private static int getPositionOnItem(Spinner spinner,Item item){
        int position = 0;
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).equals(item)) {
               position = i;
            }
        }
        return position;
    }
}
