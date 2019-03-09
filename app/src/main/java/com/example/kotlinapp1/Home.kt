package com.example.kotlinapp1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.kotlinapp1.R.layout.activity_home
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_home)

        // Configure action bar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "Hello Toolbar"

        // Initialize the action bar drawer toggle instance
        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            menu_drawer,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        ){
            override fun onDrawerClosed(view: View){
                super.onDrawerClosed(view)
                //toast("Drawer closed")
            }

            override fun onDrawerOpened(drawerView: View){
                super.onDrawerOpened(drawerView)
                //toast("Drawer opened")
            }
        }

        // Configure the drawer layout to add listener and show icon on toolbar
        drawerToggle.isDrawerIndicatorEnabled = true
        menu_drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        // Set navigation view navigation item selected listener
        navigation_view.setNavigationItemSelectedListener {
            when (it.itemId){
                R.id.btn_new_customer -> toast("nc clicked")
                R.id.btn_logout -> toast("l clicked")
            }

            // close the drawer
            menu_drawer.closeDrawer(GravityCompat.START)
            true
        }

        bLogout.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }
    }

    // Extension function to show toast message easily
    private fun Context.toast(message:String){
        Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        //super.onBackPressed()

    }

}