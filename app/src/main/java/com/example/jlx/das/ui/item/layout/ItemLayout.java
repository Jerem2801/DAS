package com.example.jlx.das.ui.item.layout;

import android.content.Context;
import android.widget.LinearLayout;

import com.example.jlx.das.ui.UiUtils;

public class ItemLayout {

    private ItemLayout(){

    }

    public static LinearLayout createItemLayout(Context context){
        LinearLayout itemLayout = new LinearLayout(context);
        LinearLayout.LayoutParams itemLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        itemLayoutParams.setMargins(0,0,0, UiUtils.sizeInDp(context,16));
        itemLayout.setLayoutParams(itemLayoutParams);
        itemLayout.setOrientation(LinearLayout.VERTICAL);
        return itemLayout;
    }
}
