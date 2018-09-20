package com.example.rmaddali.icryptodroid.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.rmaddali.icryptodroid.R

class SplashScreen : Fragment() , Handler.Callback{


    lateinit var handler: Handler

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val parentView =   LayoutInflater.from(container?.context).inflate(R.layout.splash_layout,container, false)


        return parentView
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        handler = Handler(this)
        handler.postDelayed({

        Navigation.findNavController(activity!!,R.id.app_titlez).navigate(R.id.action_splashScreen_to_coinListFragment)
        }, 1000)
    }


    override fun handleMessage(p0: Message?): Boolean {

        return true
    }
}