package com.example.jlx.das.ui.button;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.jlx.das.R;
import com.example.jlx.das.controller.MainActivity;
import com.example.jlx.das.controller.fragment.CustomFragment;
import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.stream.RessourceUtils;
import com.example.jlx.das.ui.ToastUtils;
import com.google.common.collect.Maps;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class CustomButtonEditDisplay {



    public static Button getButton(final CustomFragment customFragment,final Context context,final String fragmentId,final int layoutId,final int linearId, final String mode,final LinearLayout linearMother,final Map<Integer,ItemRule> test) {
        Button button = new Button(context);
        String text = context.getResources().getString(R.string.edit);
        if(StringUtils.equals(mode,CustomFragment.MODE_EDIT)){
            text = context.getResources().getString(R.string.save);
        }
        button.setText(text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) customFragment.getActivity();
                String modeToApply = CustomFragment.MODE_EDIT;
                if(StringUtils.equals(mode,modeToApply)){
                    StringBuilder builder = new StringBuilder();
                    for(Map.Entry<Integer, ItemRule> entry : test.entrySet()){
                        Integer key = entry.getKey();
                        ItemRule itemRule = entry.getValue();
                        View viewById = linearMother.findViewById(key);
                        if(StringUtils.equals(itemRule.getTypeValue(),"custom")){
                            EditText text = (EditText) viewById;
                            if(text != null){
                                builder.append(itemRule.getId()+";"+text.getText().toString());
                                //ToastUtils.showToast(context,text.getText().toString());
                            }
                        }else{
                            Spinner spinner = (Spinner) viewById;
                            Item item = (Item) spinner.getSelectedItem();
                            if(item != null){
                                builder.append(itemRule.getId()+";"+item.getId());
                                //ToastUtils.showToast(context,item.getId());
                            }
                        }
                        builder.append("\n");
                    }
                    RessourceUtils.writeFile(context,fragmentId + ".csv",builder.toString());
                    modeToApply = CustomFragment.MODE_DISPLAY;
                }
                CustomFragment fragment = activity.getCustomFragment(fragmentId,layoutId,linearId,modeToApply);
                activity.getSupportFragmentManager().beginTransaction().detach(fragment).attach(fragment).commit();
            }
        });

        return button;
    }
}
