package com.greate43.sk.optussenerio2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.greate43.sk.optussenerio2.services.model.Photos
import com.greate43.sk.optussenerio2.services.model.Users
import com.greate43.sk.optussenerio2.services.repository.Repository

class MainViewModel : ViewModel() {
    fun listUser(): LiveData<Users> {
        return Repository.listUsers()
    }

    fun getPhotoById(id: Int): LiveData<Photos> {
        return Repository.getPhotosByUserId(id)
    }
}