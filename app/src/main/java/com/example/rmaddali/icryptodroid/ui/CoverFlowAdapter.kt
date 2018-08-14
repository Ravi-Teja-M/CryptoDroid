package com.example.rmaddali.icryptodroid.ui

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.rmaddali.icryptodroid.R
import com.example.rmaddali.icryptodroid.ui.model.CryptoInfoModel
import com.example.rmaddali.icryptodroid.ui.model.Data
import com.example.rmaddali.icryptodroid.ui.utils.UrlUtil
import com.squareup.picasso.Picasso

class CoverFlowAdapter(context : Context) : androidx.recyclerview.widget.RecyclerView.Adapter<ViewHolders>()  {

    var listItems: List<Data>  = emptyList()
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolders {

      var layout =   LayoutInflater.from(p0.context).inflate(R.layout.coverflow_card_layout , p0, false)

      return ViewHolders(layout)
    }

    override fun getItemCount(): Int {

        return (listItems?.size)
    }

    override fun onBindViewHolder(holder: ViewHolders, index: Int) {

        holder.title.text =  listItems.get(index).symbol
        holder.description.text =  listItems.get(index).name

        holder.rank.text  = "# ${listItems.get(index).id}"
        holder.currentValue.text = listItems.get(index).first_historical_data

        Picasso.get().load(   UrlUtil.getCoinLogoUrlFromId( (listItems?.get(index).id))  ).into(holder.coinLogo)
      }

    fun updateData(cryptoInfo: CryptoInfoModel) {

        listItems = cryptoInfo?.data
    }
}

  class ViewHolders(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

      lateinit  var title :TextView
      lateinit  var description: TextView
      lateinit  var currentValue: TextView
      lateinit  var rank:TextView
      lateinit  var coinLogo:ImageView

      var parent :View = itemView

      init {
          initViews()
      }

      private fun initViews() {

          title = parent.findViewById(R.id.coin_code_txt)
          description = parent.findViewById(R.id.coin_name_txt)
          currentValue = parent.findViewById(R.id.coin_status_xtras)
          rank = parent.findViewById(R.id.rank)
          coinLogo = parent.findViewById(R.id.coin_logo)
      }


  }
