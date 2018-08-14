package com.example.rmaddali.icryptodroid.ui

import android.app.Application
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class Applications : Application() {

     object RetrofitSingleton{
            var CMC_PRO_API_KEY:String  = "368777e0-207f-437f-aaee-ed6662e0eacf"

            open  fun initRetrofit() : Retrofit
            {

                var retrofit  = Retrofit.Builder()
                        //
                        // .baseUrl("https://api.nexchange.io/en/api/")
                        .baseUrl("https://pro-api.coinmarketcap.com/")
                        .addConverterFactory(GsonConverterFactory.create(Gson()))
                        .build()

                return retrofit
            }
        }



    }



