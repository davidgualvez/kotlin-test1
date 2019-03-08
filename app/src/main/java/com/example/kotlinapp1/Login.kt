package com.example.kotlinapp1

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log.d
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etUsername.requestFocus()

        bLogin.setOnClickListener {
            var etU     = etUsername.text.trim().toString()
            var etP     = etPassword.text.trim().toString()

            if(etU == "" || etU == null){
                showMsg("Username is required")
                etUsername.setText("")
                etUsername.requestFocus()
                return@setOnClickListener
            }

            if(etP == "" || etP == null){
                showMsg("Password is required")
                etPassword.setText("")
                etPassword.requestFocus()
                return@setOnClickListener
            }

            if(etU != "admin" && etP != "admin"){
                showMsg("Invalid Credentials")
                return@setOnClickListener
            }

            if(etU == "admin" && etP == "admin"){
                startActivity( Intent(this, Home::class.java) )
            }
        }

    }

    override fun onBackPressed() {
        //super.onBackPressed()
    }

    fun showMsg(msg: String){
        d("debug", "$msg")
        Toast.makeText(applicationContext, "$msg", Toast.LENGTH_SHORT).show()
    }
}