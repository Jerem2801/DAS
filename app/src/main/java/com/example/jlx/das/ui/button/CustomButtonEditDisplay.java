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
import com.example.jlx.das.controller.fragment.FragmentReference;
import com.example.jlx.das.controller.fragment.ModeFragment;
import com.example.jlx.das.entry.character.save.SaveAction;
import com.example.jlx.das.entry.item.Item;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.stream.RessourceUtils;
import com.example.jlx.das.ui.ToastUtils;
import com.google.common.collect.Maps;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class CustomButtonEditDisplay {



    public static Button getButton(final CustomFragment customFragment, final Context context, final FragmentReference fragmentReference, final ModeFragment mode, final LinearLayout linearMother, final Map<Integer,ItemRule> test) {
        Button button = new Button(context);
        String text = context.getResources().getString(mode.getTextId());
        button.setText(text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) customFragment.getActivity();
                if(mode.isSave()){
                    SaveAction.save(context,fragmentReference.getName(),linearMother,test);
                }
                ModeFragment modeToApply = ModeFragment.getMode(mode.getOppositeId());
                CustomFragment fragment = activity.getCustomFragment(fragmentReference,modeToApply);
                activity.getSupportFragmentManager().beginTransaction().detach(fragment).attach(fragment).commit();
            }
        });

        return button;
    }
}
