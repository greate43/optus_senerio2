package com.greate43.sk.optussenerio2.services.repository

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {
     private val TAG = ServiceGenerator::class.java.simpleName
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    private val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())


    private val retrofit = retrofitBuilder.build()

    private val requestApi: JsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)

    fun getRequestApi(): JsonPlaceHolderApi {
        return requestApi
    }
}