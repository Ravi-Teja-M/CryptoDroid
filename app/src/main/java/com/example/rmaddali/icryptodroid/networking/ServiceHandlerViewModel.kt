package com.example.rmaddali.icryptodroid.networking

import android.app.Application
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.example.rmaddali.icryptodroid.db.RoomDbManager
import com.example.rmaddali.icryptodroid.ui.Applications
import com.example.rmaddali.icryptodroid.model.CryptoInfoModel
import com.example.rmaddali.icryptodroid.model.Data
import com.example.rmaddali.icryptodroid.networking.serviceimpl.CryptoInfoServiceImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServiceHandlerViewModel(application: Application) : AndroidViewModel(application){

    var mCoinList : MutableLiveData<List<Data>> ? = MutableLiveData()

    fun getCryptoCoins(successCallback : ( ) -> Unit? , failureCallback : ()-> Unit ){

        var retrofit = Applications.RetrofitSingleton.initRetrofit()
        var cryptoInfoServiceImpl =  retrofit.create(CryptoInfoServiceImpl::class.java)

        var queryMap = HashMap<String,String>()
        queryMap.put("CMC_PRO_API_KEY", Applications.RetrofitSingleton.CMC_PRO_API_KEY)

        var callingObject  :Call<CryptoInfoModel> = cryptoInfoServiceImpl.getCryptoInfo(queryMap)

        callingObject.enqueue(object : Callback<CryptoInfoModel> {

            override fun onFailure(call: Call<CryptoInfoModel>?, t: Throwable?) {
                Log.v(""," resp failed ")

                failureCallback()
            }

            override fun onResponse(call: Call<CryptoInfoModel>?, response: Response<CryptoInfoModel>?) {
                mCoinList?.value = response!!.body()!!.data

                mCoinList?.value?.let {
                    saveDataToRoom(mCoinList?.value!!)

                }
                successCallback()
            }
        })
    }

    private fun saveDataToRoom(value: List<Data>)   {


        RoomDbManager.getInstance(getApplication()).getCoinDataDao().insertCoinData(value)



    }

    override fun onCleared() {
        super.onCleared()
        RoomDbManager.getInstance(getApplication()).close()
    }

}

