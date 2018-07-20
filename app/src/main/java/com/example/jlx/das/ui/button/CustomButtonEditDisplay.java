package com.example.jlx.das.ui.button;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.jlx.das.controller.MainActivity;
import com.example.jlx.das.controller.fragment.CustomFragment;
import com.example.jlx.das.controller.fragment.FragmentReference;
import com.example.jlx.das.controller.fragment.ModeType;
import com.example.jlx.das.entry.character.CharacterSave;
import com.example.jlx.das.entry.rule.ItemRule;

import java.util.Map;

public class CustomButtonEditDisplay {



    public static Button getButton(final CustomFragment customFragment, final Context context, final FragmentReference fragmentReference, final ModeType mode, final LinearLayout linearMother, final Map<Integer,ItemRule> rules) {
        Button button = new Button(context);
        String text = context.getResources().getString(mode.getTextId());
        button.setText(text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) customFragment.getActivity();
                if(mode.isSave()){
                    CharacterSave.save(context,fragmentReference.getName(),linearMother,rules);
                }
                ModeType modeToApply = ModeType.getMode(mode.getOppositeId());
                CustomFragment fragment = activity.getCustomFragment(fragmentReference,modeToApply);
                activity.getSupportFragmentManager().beginTransaction().detach(fragment).attach(fragment).commit();
            }
        });

        return button;
    }
}
