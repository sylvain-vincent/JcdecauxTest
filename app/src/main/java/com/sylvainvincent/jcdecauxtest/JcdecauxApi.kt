package com.sylvainvincent.jcdecauxtest

import com.sylvainvincent.jcdecauxtest.datas.Station
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

internal interface JcdecauxApi {

    @GET("stations?contract={contractName}&apiKey={apiKey}")
    fun getStations(@Query("contractName") contractName : String,
                    @Query("apiKey") apiKey : String) : Observable<Station>

    companion object {
        fun create(): JcdecauxApi {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(
                            RxJava2CallAdapterFactory.create())
                    .addConverterFactory(
                            GsonConverterFactory.create())
                    .baseUrl("https://api.jcdecaux.com/vls/v1/")
                    .build()

            return retrofit.create(JcdecauxApi::class.java)
        }
    }


}
