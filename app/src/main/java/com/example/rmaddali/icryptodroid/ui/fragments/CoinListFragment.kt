package com.example.rmaddali.icryptodroid.ui.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.rmaddali.icryptodroid.R
import com.example.rmaddali.icryptodroid.model.CryptoInfoModel
import com.example.rmaddali.icryptodroid.networking.getCryptoCoins
import com.example.rmaddali.icryptodroid.ui.adapters.CoverFlowAdapter
import com.example.rmaddali.icryptodroid.ui.adapters.OnListItemClicked
import com.google.android.material.bottomnavigation.BottomNavigationView

class CoinListFragment : Fragment() , OnListItemClicked {

    private lateinit var parentView: View
    private lateinit var recyclerView : androidx.recyclerview.widget.RecyclerView
    private lateinit var mCoverFlowAdapter: CoverFlowAdapter
    private lateinit var mProgressBar: ProgressBar
    private lateinit var mViewMoreLabel: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        parentView = LayoutInflater.from(container!!.context).inflate(R.layout.coin_list_fragment,container,false)
        initViews(parentView)
        initBottomBar(parentView)

        return parentView
    }

    private fun updateListData(cryptoInfo: CryptoInfoModel)  {
        (context!! as Activity).runOnUiThread{
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

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.cover_recycler)
        mViewMoreLabel = view.findViewById(R.id.view_more)
        mProgressBar = view.findViewById(R.id.progressBar)
        mViewMoreLabel.setOnClickListener{
            onViewMoreClicked()
        }
        mCoverFlowAdapter = CoverFlowAdapter(context!! , this@CoinListFragment)
        var linearLayoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity,androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = mCoverFlowAdapter

    }

    private  fun initBottomBar(view: View){
        var bottomNavigationMenu: BottomNavigationView = view.findViewById(R.id.bottomNavigationView)
        bottomNavigationMenu.inflateMenu(R.menu.tab_menu_dashboard)
        bottomNavigationMenu.setOnNavigationItemSelectedListener { _ ->
            true
        }
    }

    fun onViewMoreClicked() :Unit{

    }

    override fun onItemClicked(viewGroup: View, position: Int) {

        /*var intent = Intent(activity, CoinDetailsActivity::class.java)
        startActivity(intent)*/


        Navigation.findNavController(activity!!,viewGroup.id).navigate(R.id.action_coinListFragment_to_coinDetailsFragment)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        getCryptoCoins(fun(cryptoInfo : CryptoInfoModel){ //Success callback

            updateListData(cryptoInfo)
            recyclerView.visibility= View.VISIBLE
            mProgressBar.visibility = View.GONE

        },  fun() { //Failure Callback
            mProgressBar.visibility = View.GONE
        })

    }
}