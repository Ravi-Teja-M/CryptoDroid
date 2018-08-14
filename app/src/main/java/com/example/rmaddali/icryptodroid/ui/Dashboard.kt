
package com.example.rmaddali.icryptodroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
 import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
 import com.example.rmaddali.icryptodroid.R
import com.example.rmaddali.icryptodroid.ui.model.CryptoInfoModel
import com.example.rmaddali.icryptodroid.ui.networking.getCryptoCoins

class Dashboard : AppCompatActivity() {

    lateinit var recyclerView : androidx.recyclerview.widget.RecyclerView
    lateinit var mCoverFlowAdapter: CoverFlowAdapter
    lateinit var mProgressBar: ProgressBar
    lateinit var mViewMoreLabel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        initViews()
        initBottomBar()

        mProgressBar.visibility = View.VISIBLE

        getCryptoCoins(fun(cryptoInfo : CryptoInfoModel){ //Success callback

           updateListData(cryptoInfo)
            recyclerView.visibility= View.VISIBLE
           mProgressBar.visibility = View.GONE


        },  fun() { //Failure Callback

            mProgressBar.visibility = View.GONE
       })
    }

    private fun updateListData(cryptoInfo: CryptoInfoModel)  {
        runOnUiThread{
            mCoverFlowAdapter.updateData(cryptoInfo)
            mCoverFlowAdapter.notifyDataSetChanged()

            if(cryptoInfo?.data?.size> 10){
                mViewMoreLabel.visibility = View.VISIBLE
            }
            else{
                mViewMoreLabel.visibility = View.GONE
            }
        }
    }


    private fun initViews() {
        recyclerView = findViewById(R.id.cover_recycler)
        mViewMoreLabel = findViewById(R.id.view_more)
        mProgressBar = findViewById(R.id.progressBar)
        mViewMoreLabel.setOnClickListener{
            onViewMoreClicked()
        }
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


    fun onViewMoreClicked() :Unit{

    }
}
