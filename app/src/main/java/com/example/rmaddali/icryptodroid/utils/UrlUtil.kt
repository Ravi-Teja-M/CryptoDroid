package com.example.rmaddali.icryptodroid.utils


object  UrlUtil{

    fun getCoinLogoUrlFromId(id: Int) : String? {

        var url = "https://s2.coinmarketcap.com/static/img/coins/64x64/#.png"

        id!!.let {

            return url.replace("#", id.toString())
        }
        return null
    }
}
