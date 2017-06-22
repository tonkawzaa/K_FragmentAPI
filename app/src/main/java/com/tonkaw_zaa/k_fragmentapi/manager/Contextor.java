package com.tonkaw_zaa.k_fragmentapi.manager;

import android.content.Context;

/**
 * Created by Tonkaw_Zaa on 6/22/2017.
 */

public class Contextor {
    private static Contextor instance;

    public static Contextor getInstance() {
        if (instance == null)
            instance = new Contextor();
        return instance;
    }

    private Context mContext;

    private Contextor() {

    }

    public void init(Context context) {
        mContext = context;
    }

    public Context getContext() {
        return mContext;
    }
}
