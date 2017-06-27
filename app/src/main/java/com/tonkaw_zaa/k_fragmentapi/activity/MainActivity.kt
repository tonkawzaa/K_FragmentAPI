package com.tonkaw_zaa.k_fragmentapi.activity

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast

import com.tonkaw_zaa.k_fragmentapi.R
import com.tonkaw_zaa.k_fragmentapi.fragment.MainFragment
import com.tonkaw_zaa.k_fragmentapi.fragment.SecondFragment
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    var drawerlayout : DrawerLayout by Delegates.notNull()
    var btSample : Button by Delegates.notNull()
    var actionBarDrawerToggle : ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initInstances()
        setupNavigationView()

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                    .add(R.id.contentContainer,MainFragment.newInstance())
                    .commit()
        }

    }

    private fun setupNavigationView() {
        btSample = findViewById(R.id.btSample) as Button

        btSample.setOnClickListener {
            var fragment :Fragment? = supportFragmentManager.findFragmentById(R.id.contentContainer)
            if(fragment !is SecondFragment){
                Toast.makeText(this@MainActivity,"Sample",Toast.LENGTH_LONG).show()
                supportFragmentManager.beginTransaction()
                        .replace(R.id.contentContainer,SecondFragment.newInstance())
                        .addToBackStack(null)
                        .commit()
                drawerlayout.closeDrawers()
            }
        }
    }

    private fun initInstances() {
        drawerlayout = findViewById(R.id.drawerlayout) as DrawerLayout
        actionBarDrawerToggle = ActionBarDrawerToggle(
                this@MainActivity, drawerlayout, R.string.open_drawer, R.string.close_drawer)
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
        if (item?.itemId == R.id.action_settings) {
            Toast.makeText(this@MainActivity,"Setting",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }


}
