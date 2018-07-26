package com.example.jlx.das.ui.dialog.list;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import com.example.jlx.das.R;
import com.example.jlx.das.data.DataPoolManager;
import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.entry.item.ItemUtils;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.ToastUtils;
import com.example.jlx.das.ui.item.type.attribute.value.Focus;
import com.google.android.flexbox.FlexboxLayout;
import com.google.common.collect.Lists;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.List;

public class DialogListFactory {

    public static Dialog createCustomDialog(final Context context, final FlexboxLayout flexboxLayout,ItemRule itemRule,String value){
        final List<Integer> selectedItems = Lists.newArrayList();
        final List<Item> items = DataPoolManager.getItems(itemRule.getReference());
        final String[] names = ItemUtils.getNamesOfItemsInArray(items);
        boolean[] checkedItems = getCheckedItems(selectedItems,items,value);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(itemRule.getName());
        builder.setMultiChoiceItems(names, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    selectedItems.add(which);
                } else {
                    selectedItems.remove(Integer.valueOf(which));
                }
            }
        });
        builder.setPositiveButton(context.getResources().getString(R.string.valid), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                flexboxLayout.removeAllViews();
                addSelectedItem(context,selectedItems,flexboxLayout);
                String separator = StringUtils.EMPTY;
                if(selectedItems.size() > 1){
                    separator = ",";
                }
                for(Integer i : selectedItems){
                    Item item = items.get(i);
                    TextView focus = Focus.createFocusList(context,item,separator);
                    flexboxLayout.addView(focus);
                }
            }
        });
       builder .setNegativeButton(context.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

            }
        });

        return builder.create();

    }

    private static boolean[] getCheckedItems(List<Integer> selectedItems,List<Item> items, String value) {
        List<String> split = Arrays.asList(StringUtils.split(value, "&"));
        boolean[] checkedItems = new boolean[items.size()];
        int index = 0;
        for(Item item : items){
            if(split.contains(item.getId())) {
                selectedItems.add(index);
                checkedItems[index] = true;
            }
            index++;
        }
        return checkedItems;
    }

    private static void addSelectedItem(Context context,List<Integer> selectedItems,FlexboxLayout flexboxLayout){
        String joinIds = StringUtils.join(selectedItems, "&");
        TextView ids = new TextView(context);
        ids.setText(joinIds);
        ids.setVisibility(View.GONE);
        flexboxLayout.addView(ids,0);
    }

}
