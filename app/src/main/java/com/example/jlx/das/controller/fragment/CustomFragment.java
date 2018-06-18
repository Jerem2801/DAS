package com.example.jlx.das.controller.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.jlx.das.entry.character.Character;
import com.example.jlx.das.entry.character.CharacterReader;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.CustomCaraView;
import com.example.jlx.das.R;

import java.util.Map;

public class CustomFragment extends Fragment {

    private static String FRAGMENT_ID;
    private static int FRAGMENT_LAYOUT_ID;
    private static int FRAGMENT_LINEAR_ID;

    public static CustomFragment newInstance(String id, int layoutId,int linearId) {
        FRAGMENT_ID = id;
        FRAGMENT_LAYOUT_ID = layoutId;
        FRAGMENT_LINEAR_ID = linearId;
        return (new CustomFragment());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(FRAGMENT_LAYOUT_ID, container, false);
        Context context = rootView.getContext();
        LinearLayout linearMother = rootView.findViewById(FRAGMENT_LINEAR_ID);

        Character fragmentCharacter = CharacterReader.getCharacter(context, FRAGMENT_ID);

        for(Map.Entry<ItemRule, String> entry : fragmentCharacter.getRuleAndValue().entrySet()){
            ItemRule itemRule = entry.getKey();
            String value = entry.getValue();
            CustomCaraView customView = new CustomCaraView(context,linearMother,itemRule,value);
            customView.createCustomCataView();
        }


        return rootView;
    }


}
