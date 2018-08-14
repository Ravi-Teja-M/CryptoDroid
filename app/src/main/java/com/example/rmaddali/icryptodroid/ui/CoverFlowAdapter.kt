package com.example.rmaddali.icryptodroid.ui

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rmaddali.icryptodroid.R
import com.example.rmaddali.icryptodroid.ui.model.CryptoInfoModel
import com.example.rmaddali.icryptodroid.ui.model.Data

class CoverFlowAdapter(context : Context) : androidx.recyclerview.widget.RecyclerView.Adapter<ViewHolders>()  {

    var listItems: List<Data>  = emptyList()
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolders {

      var layout =   LayoutInflater.from(p0.context).inflate(R.layout.coverflow_card_layout , p0, false)

      return ViewHolders(layout)
    }

    override fun getItemCount(): Int {

        return (listItems?.size)
    }

    override fun onBindViewHolder(p0: ViewHolders, p1: Int) {

     }

    fun updateData(cryptoInfo: CryptoInfoModel) {

        listItems = cryptoInfo?.data
    }
}

  class ViewHolders(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {



  }
