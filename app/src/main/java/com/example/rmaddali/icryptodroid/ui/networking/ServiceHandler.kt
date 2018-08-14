package com.example.rmaddali.icryptodroid.ui.networking

import android.util.Log
import com.example.rmaddali.icryptodroid.ui.Applications
import com.example.rmaddali.icryptodroid.ui.model.CryptoInfoModel
import com.example.rmaddali.icryptodroid.ui.networking.serviceimpl.CryptoInfoServiceImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.abs


fun getCryptoCoins(ab : (cryptoInfo : CryptoInfoModel) -> Unit?){

    var retrofit = Applications.RetrofitSingleton.initRetrofit()
    var cryptoInfoServiceImpl =  retrofit.create(CryptoInfoServiceImpl::class.java)

    var queryMap = HashMap<String,String>()
    queryMap.put("CMC_PRO_API_KEY", Applications.RetrofitSingleton.CMC_PRO_API_KEY)

    var callingObject  :Call<CryptoInfoModel> = cryptoInfoServiceImpl.getCryptoInfo(queryMap)
    callingObject.enqueue(object : Callback<CryptoInfoModel> {

        override fun onFailure(call: Call<CryptoInfoModel>?, t: Throwable?) {
            Log.v(""," resp failed ")
        }

        override fun onResponse(call: Call<CryptoInfoModel>?, response: Response<CryptoInfoModel>?) {
            //Log.v(""," resp on resp " + response?.body().toString())
            ab(response!!.body()!!)
            }

    })
}



fun  abs(hello : (h2: Int) ->String  ,  vali : String ){

}