package com.greate43.sk.optussenerio2.services.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import com.greate43.sk.optussenerio2.services.model.Photos
import com.greate43.sk.optussenerio2.services.model.Users
import com.greate43.sk.optussenerio2.services.repository.ServiceGenerator.getRequestApi
import io.reactivex.rxjava3.schedulers.Schedulers


object Repository {

    fun listUsers(): LiveData<List<Users>> {
        return LiveDataReactiveStreams.fromPublisher(
            getRequestApi()
                .listUsers()
                .subscribeOn(Schedulers.io())
        )
    }

    fun getPhotosByUserId(id: Int): LiveData<List<Photos>> {
        return LiveDataReactiveStreams.fromPublisher(
            getRequestApi()
                .getPhotosById(id)
                .subscribeOn(Schedulers.io())
        )
    }
}