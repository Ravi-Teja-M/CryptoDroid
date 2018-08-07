
package com.example.rmaddali.icryptodroid.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
 import android.support.design.widget.BottomNavigationView
 import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
 import com.example.rmaddali.icryptodroid.R
import com.example.rmaddali.icryptodroid.ui.networking.getCryptoCoins

class Dashboard : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var mCoverFlowAdapter: CoverFlowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        initViews()
        initBottomBar()


        var serviceHandler =  getCryptoCoins(context = applicationContext as Applications)
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.cover_recycler)
        mCoverFlowAdapter = CoverFlowAdapter(this)
        var linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = mCoverFlowAdapter
    }

    private  fun initBottomBar(){

        var bottomNavigationMenu: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationMenu.inflateMenu(R.menu.tab_menu_dashboard)
        bottomNavigationMenu.setOnNavigationItemSelectedListener { menuItems ->

             true
        }
    }
}
