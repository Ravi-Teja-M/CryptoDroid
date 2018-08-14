package com.example.rmaddali.icryptodroid.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rmaddali.icryptodroid.R

class CoinDetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

     val parentView =   LayoutInflater.from(container?.context).inflate(R.layout.coin_details_fragment,container, false)


        return parentView
    }


}