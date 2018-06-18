package com.example.jlx.das.data;

import android.content.Context;

public class DataPoolFactory {

    private DataPoolFactory(){

    }

    public static DataPool getDataLoader(Context context){
        DataPool dataPool = new DataPool();

        dataPool.setItems(DataPoolReader.getData(context));

        return dataPool;
    }
}
