package com.example.jlx.das.ui.dialog.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jlx.das.R;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.UiUtils;

import org.w3c.dom.Text;

public class DialogDescription {

    private DialogDescription(){

    }

    public static LinearLayout createDialogDescription(Context context, String description){
        //LINEAR
        LinearLayout linearLayout = createLinearLayout(context);

        //TITLE
        TextView titleDescription = createTitleDescription(context);
        linearLayout.addView(titleDescription);

        //LINE
        LinearLayout line = createLine(context);
        linearLayout.addView(line);

        //DESCRIPTION
        TextView descView = createDescriptionView(context,description);
        linearLayout.addView(descView);

        return linearLayout;
    }



    private static LinearLayout createLinearLayout(Context context){
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayout.setPadding(UiUtils.sizeInDp(context,16),0,UiUtils.sizeInDp(context,16),0);
        linearLayout.setLayoutParams(linearParams);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        return linearLayout;
    }

    public static TextView createTitleDescription(Context context){
        TextView textView =  new TextView(context);
        LinearLayout.LayoutParams paramsKeyName = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        paramsKeyName.setMargins(UiUtils.sizeInDp(context,8), UiUtils.sizeInDp(context,8), 0, 0);
        textView.setLayoutParams(paramsKeyName);
        textView.setTextColor(context.getResources().getColor(R.color.colorPrimary));
        textView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        textView.setText("Description");
        return textView;
    }

    private static LinearLayout createLine(Context context) {
        LinearLayout line = new LinearLayout(context);
        LinearLayout.LayoutParams lineParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        line.setLayoutParams(lineParams);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            line.setBackground(context.getResources().getDrawable(R.drawable.custom_line));
        }
        return line;
    }

    private static TextView createDescriptionView(Context context,String description){
        TextView descView = new TextView(context);
        LinearLayout.LayoutParams descViewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        descViewParams.setMargins(UiUtils.sizeInDp(context,8),  UiUtils.sizeInDp(context,8), UiUtils.sizeInDp(context,16),UiUtils.sizeInDp(context,16));
        descView.setLayoutParams(descViewParams);
        description = description.substring(0, 1).toUpperCase() + description.substring(1);
        descView.setText(description);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            descView.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        }
        return descView;
    }


}
