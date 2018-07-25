package com.example.jlx.das.ui.dialog.list;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.ui.ToastUtils;
import com.google.android.flexbox.FlexboxLayout;
import com.google.common.collect.Lists;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Text;

import java.util.List;

public class DialogListFactory {

    public static Dialog createCustomDialog(final Context context, String title, final List<Item> items,final FlexboxLayout flexboxLayout){
        final List<Integer> mSelectedItems = Lists.newArrayList(); // Where we track the selected items
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final String[] names = getName(items);

        builder.setTitle(title).setMultiChoiceItems(names, null,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which,
                                        boolean isChecked) {
                        if (isChecked) {
                            mSelectedItems.add(which);
                        } else if (mSelectedItems.contains(which)) {
                            mSelectedItems.remove(Integer.valueOf(which));
                        }
                        ToastUtils.showToast(context,names[which]);
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                flexboxLayout.removeAllViews();
                String join = StringUtils.join(mSelectedItems, ";");
                TextView ids = new TextView(context);
                ids.setText(join);
                ids.setVisibility(View.INVISIBLE);
                flexboxLayout.addView(ids,0);
                for(Integer i : mSelectedItems){
                    Item item = items.get(i);
                    TextView focus = new TextView(context);
                    focus.setText(item.getName());
                    flexboxLayout.addView(focus);
                }
            }
        })
        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

            }
        });

        return builder.create();

    }

    private static String[]  getName(List<Item> items){
        List<String> names = Lists.newArrayList();
        for(Item item : items){
            names.add(item.getName());
        }
        String[] lists = names.toArray(new String[names.size()]);
        return lists;
    }

}
