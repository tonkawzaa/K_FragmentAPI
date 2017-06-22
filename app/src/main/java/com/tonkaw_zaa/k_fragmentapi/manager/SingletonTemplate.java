package com.tonkaw_zaa.k_fragmentapi.manager;

import android.content.Context;

/**
 * Created by Tonkaw_Zaa on 6/22/2017.
 */

public class SingletonTemplate {
    private static SingletonTemplate instance;

    public static  SingletonTemplate getInstance() {
        if (instance == null)
            instance = new SingletonTemplate();
        return instance;
    }

    private Context mContext;

    private SingletonTemplate() {
        mContext = Contextor.getInstance().getContext();
    }
}
