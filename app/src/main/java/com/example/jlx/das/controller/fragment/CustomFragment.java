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

import com.example.jlx.das.R;
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.button.CustomButtonEditDisplay;
import com.example.jlx.das.ui.custom.view.CustomView;
import com.google.common.collect.Maps;

import java.util.Map;

public class CustomFragment extends Fragment {

    public static String FRAGMENT_ID = "fragmentId";
    public static String MODE = "mode";

    public static CustomFragment newInstance() {
        return (new CustomFragment());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        int fragmentId = getArguments().getInt(FRAGMENT_ID);
        FragmentReference fragmentReference = FragmentReference.getMode(fragmentId);
        final ModeType modeType = ModeType.getMode(getArguments().getString(MODE));

        View rootView = inflater.inflate(R.layout.sheet_fragment, container, false);
        Context context = rootView.getContext();
        LinearLayout linearMother = rootView.findViewById(R.id.fragment_rootview);

        Map<Integer,ItemRule> test = Maps.newHashMap();

        CustomView customView = new CustomView(context,linearMother,fragmentReference.getName(), modeType);
        customView.createCustomView(test);

        Button button = CustomButtonEditDisplay.getButton(this,context,fragmentReference, modeType,linearMother,test);
        linearMother.addView(button);


        return rootView;
    }


}
