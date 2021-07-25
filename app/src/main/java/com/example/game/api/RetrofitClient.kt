package com.example.game.api

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {

        private const val BASE_URL ="https://kiongamersapi.azurewebsites.net"
        private var retrofit : Retrofit?= null

        private fun getInstance():Retrofit{



            if (retrofit==null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }
            return retrofit!!
        }

        fun getApis():WebServiceDAO{
            return getInstance().create(WebServiceDAO::class.java)

        }
        fun hasNetwork(context: Context):Boolean{
            var isOnline : Boolean = false
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
            if (activeNetwork!=null&&activeNetwork.isConnected) isOnline = true

            return isOnline
        }
    }
}