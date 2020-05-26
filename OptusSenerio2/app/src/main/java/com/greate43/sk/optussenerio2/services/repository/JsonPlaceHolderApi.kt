package com.greate43.sk.optussenerio2.services.repository

import com.greate43.sk.optussenerio2.services.model.Photos
import com.greate43.sk.optussenerio2.services.model.Users
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface JsonPlaceHolderApi {
    @GET("users")
    fun listUsers(): Flowable<List<Users>>

    @GET("photos")
    fun getPhotosById(@Query("albumId") id :Int ): Flowable<List<Photos>>
}