package com.example.jlx.das.controller.fragment;

import com.example.jlx.das.R;
import com.google.common.collect.Maps;

import java.util.Map;

public enum FragmentReference {

    PROFIL(R.id.activity_main_drawer_profil,"profile"),
    APPAREANCE(R.id.activity_main_drawer_appareance,"appareance"),
    ROLEPLAY(R.id.activity_main_drawer_roleplay,"roleplay");

    private int menuId;
    private String name;

    FragmentReference(int menuId, String name) {
        this.menuId = menuId;
        this.name = name;
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

}
