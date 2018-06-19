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
import com.example.jlx.das.entry.rule.ItemRule;
import com.example.jlx.das.ui.button.CustomButtonEditDisplay;
import com.example.jlx.das.ui.custom.view.CustomView;
import com.google.common.collect.Maps;

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
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final String fragmentId = getArguments().getString(FRAGMENT_ID);
        final int layoutId = getArguments().getInt(FRAGMENT_LAYOUT_ID);
        final int linearId = getArguments().getInt(FRAGMENT_LINEAR_ID);
        final String mode = getArguments().getString(MODE);

        View rootView = inflater.inflate(layoutId, container, false);
        Context context = rootView.getContext();
        LinearLayout linearMother = rootView.findViewById(linearId);

        Map<Integer,ItemRule> test = Maps.newHashMap();

        CustomView customView = new CustomView(context,linearMother,fragmentId,mode);
        customView.createCustomView(test);

        Button button = CustomButtonEditDisplay.getButton(this,context,fragmentId,layoutId,linearId,mode,linearMother,test);
        linearMother.addView(button);


        return rootView;
    }


}
