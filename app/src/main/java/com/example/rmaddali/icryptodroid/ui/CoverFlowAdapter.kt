package com.example.rmaddali.icryptodroid.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rmaddali.icryptodroid.R

class CoverFlowAdapter(context : Context) : RecyclerView.Adapter<ViewHolders>()  {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolders {

      var layout =   LayoutInflater.from(p0.context).inflate(R.layout.coverflow_card_layout , p0, false)

      return ViewHolders(layout)
    }

    override fun getItemCount(): Int {

        return 20
    }

    override fun onBindViewHolder(p0: ViewHolders, p1: Int) {

     }
}

  class ViewHolders(itemView: View) : RecyclerView.ViewHolder(itemView) {



  }
