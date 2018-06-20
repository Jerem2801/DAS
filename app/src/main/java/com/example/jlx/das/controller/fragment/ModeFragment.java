package com.example.jlx.das.controller.fragment;

import com.example.jlx.das.R;
import com.google.common.collect.Maps;

import java.util.Map;

public enum ModeFragment {

    MODE_DISPLAY("display",false, R.string.edit,"edit"),
    MODE_EDIT("edit",true,R.string.save,"display");

    private String id;
    private boolean save;
    private int textId;
    private String oppositeId;

    private ModeFragment(String id,boolean save,int textId,String oppositeId){
        this.id = id;
        this.save = save;
        this.textId = textId;
        this.oppositeId = oppositeId;
    }

    private static final Map<String,ModeFragment> modeById = Maps.newHashMap();
    static{
        for(ModeFragment mode : ModeFragment.values()){
            modeById.put(mode.id,mode);
        }
    }

    public static ModeFragment getMode(String id){
        return modeById.get(id);
    }

    public String getId() {
        return id;
    }

    public boolean isSave() {
        return save;
    }

    public int getTextId() {
        return textId;
    }

    public String getOppositeId() {
        return oppositeId;
    }
}
