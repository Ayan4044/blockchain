package com.ayan.blockchain

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ayan.blockchain.model.DataClassCrypto

import com.ayan.blockchain.retrofit.RetrofitSingletonInstance
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.await
import retrofit2.awaitResponse
import java.net.ConnectException

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val context: Context = application.applicationContext

    //web view page error
    val liveviewStockData: MutableLiveData<List<DataClassCrypto>> = MutableLiveData()

    fun loadHospitalist() {

        try {
            GlobalScope.launch(Dispatchers.IO) {
                val callHospitalsRes =
                    RetrofitSingletonInstance.instance.loadCryptionCoins().awaitResponse()
                try {
                    if (callHospitalsRes.isSuccessful && callHospitalsRes.code() == 200)
                        liveviewStockData.postValue(callHospitalsRes.body())


                }
                catch (ex: JsonSyntaxException){
                    liveviewStockData.postValue(null)
                    println("Ex $ex")
                }
            }


        } catch (ex: ConnectException) {

        }
    }

}