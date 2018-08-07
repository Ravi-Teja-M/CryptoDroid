package com.example.rmaddali.icryptodroid.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import com.example.rmaddali.icryptodroid.R

class SplashScreen : AppCompatActivity() , Handler.Callback{


    lateinit var handler: Handler


      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_layout)

          handler = Handler(this)
          handler.postDelayed({

              launchListActivity()

          }, 2000)
    }

    fun launchListActivity(){

        var intent = Intent(this, Dashboard::class.java)
        startActivity(intent)
        finish()

    }


    override fun handleMessage(p0: Message?): Boolean {

        return true
    }
}