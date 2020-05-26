package com.greate43.sk.optussenerio2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.greate43.sk.optussenerio2.services.model.Photos
import com.greate43.sk.optussenerio2.services.model.Users
import com.greate43.sk.optussenerio2.services.repository.Repository

class MainViewModel : ViewModel() {
    fun listUser(): LiveData<List<Users>> {
        return Repository.listUsers()
    }

    fun getPhotoById(id: Int): LiveData<List<Photos>> {
        return Repository.getPhotosByUserId(id)
    }
}