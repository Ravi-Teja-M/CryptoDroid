
package com.example.rmaddali.icryptodroid.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.rmaddali.icryptodroid.R
import com.example.rmaddali.icryptodroid.model.CryptoInfoModel
import com.example.rmaddali.icryptodroid.networking.getCryptoCoins
import com.example.rmaddali.icryptodroid.ui.adapters.CoverFlowAdapter
import com.example.rmaddali.icryptodroid.ui.adapters.OnListItemClicked

class Dashboard : AppCompatActivity() , OnListItemClicked {

    private lateinit var recyclerView : androidx.recyclerview.widget.RecyclerView
    private lateinit var mCoverFlowAdapter: CoverFlowAdapter
    private lateinit var mProgressBar: ProgressBar
    private lateinit var mViewMoreLabel: TextView

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
        mCoverFlowAdapter = CoverFlowAdapter(this )
        var linearLayoutManager = androidx.recyclerview.widget.LinearLayoutManager(this,androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = mCoverFlowAdapter

     }

    private  fun initBottomBar(){
        var bottomNavigationMenu: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationMenu.inflateMenu(R.menu.tab_menu_dashboard)
        bottomNavigationMenu.setOnNavigationItemSelectedListener { _ ->
             true
        }
    }

    fun onViewMoreClicked() :Unit{

    }

    override fun onItemClicked(viewGroup: View, position: Int) {

        var intent = Intent(this, CoinDetailsActivity::class.java)
        startActivity(intent)

     }
}
