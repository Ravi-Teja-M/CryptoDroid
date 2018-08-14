
package com.example.rmaddali.icryptodroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
 import com.google.android.material.bottomnavigation.BottomNavigationView
 import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
 import com.example.rmaddali.icryptodroid.R
import com.example.rmaddali.icryptodroid.ui.model.CryptoInfoModel
import com.example.rmaddali.icryptodroid.ui.networking.getCryptoCoins

class Dashboard : AppCompatActivity() {

    lateinit var recyclerView : androidx.recyclerview.widget.RecyclerView
    lateinit var mCoverFlowAdapter: CoverFlowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        initViews()
        initBottomBar()

        getCryptoCoins {
            cryptoInfo: CryptoInfoModel ->

            updateListData(cryptoInfo)
        }
    }

    private fun updateListData(cryptoInfo: CryptoInfoModel)  {
        runOnUiThread{
            mCoverFlowAdapter.updateData(cryptoInfo)
            mCoverFlowAdapter.notifyDataSetChanged()
        }
    }


    private fun initViews() {
        recyclerView = findViewById(R.id.cover_recycler)
        mCoverFlowAdapter = CoverFlowAdapter(this)
        var linearLayoutManager = androidx.recyclerview.widget.LinearLayoutManager(this,androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,false)
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
