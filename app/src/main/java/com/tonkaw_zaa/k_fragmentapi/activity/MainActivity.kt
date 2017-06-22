package com.tonkaw_zaa.k_fragmentapi.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.tonkaw_zaa.k_fragmentapi.R
import com.tonkaw_zaa.k_fragmentapi.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                    .add(R.id.contentContainer,MainFragment.newInstance())
                    .commit()
        }
    }
}
