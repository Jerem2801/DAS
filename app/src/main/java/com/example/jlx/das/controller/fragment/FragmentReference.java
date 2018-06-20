package com.example.jlx.das.controller.fragment;

import com.example.jlx.das.R;
import com.google.common.collect.Maps;

import java.util.Map;

public enum FragmentReference {

    PROFIL(R.id.activity_main_drawer_profil,"profile", R.layout.sheet_profile,R.id.fragment_profile_rootview),
    APPAREANCE(R.id.activity_main_drawer_appareance,"appareance",R.layout.sheet_appareance,R.id.fragment_appareance_rootview);

    private int menuId;
    private String name;
    private int layoutId;
    private int linearId;

    FragmentReference(int menuId, String name, int layoutId, int linearId) {
        this.menuId = menuId;
        this.name = name;
        this.layoutId = layoutId;
        this.linearId = linearId;
    }

    private static final Map<Integer,FragmentReference> fragmentById = Maps.newHashMap();
    static{
        for(FragmentReference fragmentReference : FragmentReference.values()){
            fragmentById.put(fragmentReference.getMenuId(),fragmentReference);
        }
    }

    public static FragmentReference getMode(Integer menuId){
        return fragmentById.get(menuId);
    }

    public int getMenuId() {
        return menuId;
    }

    public String getName() {
        return name;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public int getLinearId() {
        return linearId;
    }
}
