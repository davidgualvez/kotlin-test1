package com.example.kotlinapp1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClick.setOnClickListener {
            d("debugging", "value was : ${editText.text}")

            startActivity(Intent(this, Home::class.java))
        }
    }

    override fun onBackPressed() {
//        super.onBackPressed()
        d("debugging", "pressed back.")

        Toast.makeText(
            applicationContext, "a", Toast.LENGTH_SHORT
        ).show()

    }
}
