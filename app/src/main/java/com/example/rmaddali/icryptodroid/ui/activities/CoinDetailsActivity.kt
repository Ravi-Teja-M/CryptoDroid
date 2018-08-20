package com.example.rmaddali.icryptodroid.ui.activities

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.rmaddali.icryptodroid.R
import com.example.rmaddali.icryptodroid.ui.fragments.CoinDetailsFragment

class CoinDetailsActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coin_details_activity)

        addCoinDetailsScreen()
    }

    fun addCoinDetailsScreen(){
        var coinDetailsFragment = CoinDetailsFragment()
        var supportFragment = supportFragmentManager.beginTransaction();
        supportFragment.replace(R.id.container , coinDetailsFragment , "coinDetailFragment")
        //supportFragment.addToBackStack(null)
        supportFragment.commit()

    }
}