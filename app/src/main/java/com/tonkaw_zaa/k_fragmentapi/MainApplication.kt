package com.tonkaw_zaa.k_fragmentapi

import android.app.Application
import com.tonkaw_zaa.k_fragmentapi.manager.Contextor

/**
 * Created by Tonkaw_Zaa on 6/22/2017.
 */
class MainApplication :Application(){
    override fun onCreate() {
        super.onCreate()

        //Initialize thing(s) here
        Contextor.getInstance().init(applicationContext)
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}