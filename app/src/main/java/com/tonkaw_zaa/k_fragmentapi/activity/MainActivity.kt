package com.tonkaw_zaa.k_fragmentapi.activity

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem

import com.tonkaw_zaa.k_fragmentapi.R
import com.tonkaw_zaa.k_fragmentapi.fragment.MainFragment
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    var drawerlayout : DrawerLayout by Delegates.notNull()
    var actionBarDrawerToggle : ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initInstances()

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                    .add(R.id.contentContainer,MainFragment.newInstance())
                    .commit()
        }

    }

    private fun initInstances() {
        drawerlayout = findViewById(R.id.drawerlayout) as DrawerLayout
        actionBarDrawerToggle = ActionBarDrawerToggle(
                this, drawerlayout, R.string.open_drawer, R.string.close_drawer)
        drawerlayout.setDrawerListener(actionBarDrawerToggle)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        actionBarDrawerToggle?.syncState()

    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        actionBarDrawerToggle?.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(actionBarDrawerToggle!!.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}
