package com.example.jlx.das.ui.item.view;

import android.os.Build;
import android.view.View;

import com.example.jlx.das.entry.rule.ItemRule;

import java.util.Map;

public class IdUtils {

    private IdUtils(){

    }

    public static void setIdToView(View view,ItemRule itemRule, Map<ItemRule,Integer> rules){
        int id = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            id = view.generateViewId();
        }
        view.setId(id);
        rules.put(itemRule,id);
    }
}
