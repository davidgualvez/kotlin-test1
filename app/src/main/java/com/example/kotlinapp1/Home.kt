package com.example.kotlinapp1

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlinapp1.R.layout.activity_home
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_home)


        bLogout.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }
    }

    override fun onBackPressed() {
        //super.onBackPressed()

    }

}