package com.example.jlx.das.ui.custom.view.normal;

import android.content.Context;
import android.os.Build;
import android.widget.LinearLayout;

import com.example.jlx.das.R;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.UiUtils;
import com.example.jlx.das.ui.custom.view.CustomLayoutView;

public class CustomNormalLayoutView implements CustomLayoutView {
    @Override
    public LinearLayout createLayoutView(Context context, ItemRule itemRule) {
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linearParams.setMargins(0,0,0, UiUtils.sizeInDp(context,16));
        linearLayout.setLayoutParams(linearParams);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            linearLayout.setBackground(context.getResources().getDrawable(R.drawable.custom_border_black));
        }
        return linearLayout;
    }
}
