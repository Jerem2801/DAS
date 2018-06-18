package com.example.jlx.das.controller.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.jlx.das.controller.MainActivity;
import com.example.jlx.das.entry.character.Character;
import com.example.jlx.das.entry.character.CharacterReader;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.CustomDisplayView;
import com.example.jlx.das.ui.CustomEditView;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class CustomFragment extends Fragment {

    public static final String MODE_EDIT = "edit";
    public static final String MODE_DISPLAY = "display";

    public static String FRAGMENT_ID = "fragmentId";
    public static String FRAGMENT_LAYOUT_ID = "layoutId";
    public static String FRAGMENT_LINEAR_ID = "linearId";
    public static String MODE = "mode";

    public static CustomFragment newInstance() {
        return (new CustomFragment());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final String fragmentId = getArguments().getString(FRAGMENT_ID);
        final int layoutId = getArguments().getInt(FRAGMENT_LAYOUT_ID);
        final int linearId = getArguments().getInt(FRAGMENT_LINEAR_ID);
        String mode = getArguments().getString(MODE);

        View rootView = inflater.inflate(layoutId, container, false);
        Context context = rootView.getContext();
        LinearLayout linearMother = rootView.findViewById(linearId);
        linearMother.removeAllViews();

        Character fragmentCharacter = CharacterReader.getCharacter(context, fragmentId);

        if(StringUtils.equals(mode,MODE_EDIT)){
            for(Map.Entry<ItemRule, String> entry : fragmentCharacter.getRuleAndValue().entrySet()){
                ItemRule itemRule = entry.getKey();
                String value = entry.getValue();
                CustomEditView customView = new CustomEditView(context,linearMother,itemRule,value);
                customView.createCustomCataView();
            }
        }else{
            for(Map.Entry<ItemRule, String> entry : fragmentCharacter.getRuleAndValue().entrySet()){
                ItemRule itemRule = entry.getKey();
                String value = entry.getValue();
                CustomDisplayView customView = new CustomDisplayView(context,linearMother,itemRule,value);
                customView.createCustomCataView();
            }
        }





        Button button = new Button(context);
        button.setText("Editer");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.showFragment(fragmentId,layoutId,linearId,MODE_EDIT);
            }
        });
        linearMother.addView(button);


        return rootView;
    }


}
