package com.example.rmaddali.icryptodroid.ui.networking.serviceimpl;

import com.example.rmaddali.icryptodroid.ui.model.CryptoInfoModel;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
 import retrofit2.http.QueryMap;

public interface CryptoInfoServiceImpl
{

    @GET("v1/cryptocurrency/map")
     Call<CryptoInfoModel> getCryptoInfo(@QueryMap Map<String, String> map);


   /* @GET("v1/currency/")
    Call<List<CryptoInfoModel>> getCryptoInfo();*/
}
