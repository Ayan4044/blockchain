package com.ayan.blockchain.retrofit

import com.ayan.blockchain.model.DataClassCrypto
import retrofit2.Call
import retrofit2.http.GET

interface APICrypto {

    @GET("ticker/24hr")
    fun loadCryptionCoins(): Call<List<DataClassCrypto>>
}