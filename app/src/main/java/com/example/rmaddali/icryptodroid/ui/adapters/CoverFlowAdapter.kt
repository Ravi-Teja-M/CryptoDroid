package com.example.rmaddali.icryptodroid.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import com.example.rmaddali.icryptodroid.R
import com.example.rmaddali.icryptodroid.model.CryptoInfoModel
import com.example.rmaddali.icryptodroid.model.Data
import com.example.rmaddali.icryptodroid.ui.activities.Dashboard
import com.example.rmaddali.icryptodroid.ui.fragments.CoinListFragment
import com.example.rmaddali.icryptodroid.utils.DiffUtilsImpl
import com.example.rmaddali.icryptodroid.utils.UrlUtil
import com.squareup.picasso.Picasso

class CoverFlowAdapter(context: Context, instance: CoinListFragment) : androidx.recyclerview.widget.RecyclerView.Adapter<ViewHolders>()  {

    var callback   = context

    private var listItems: List<Data>  = emptyList()

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

    fun updateData(cryptoInfo: List<Data>?) {

       // DiffUtil.calculateDiff( DiffUtilsImpl(listItems, cryptoInfo!!)).dispatchUpdatesTo(this) Init Diff utils
        listItems = cryptoInfo!!

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
          parent.setOnClickListener{
              val activityContext = parent!!.context

          }
      }
  }


 interface  OnListItemClicked{
     fun onItemClicked(viewGroup:View , position: Int )
 }