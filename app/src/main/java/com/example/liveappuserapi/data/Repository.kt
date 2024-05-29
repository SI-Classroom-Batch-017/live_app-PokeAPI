package com.example.liveappuserapi.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.liveappuserapi.data.model.User
import com.example.liveappuserapi.data.remote.UserApi

class Repository() {

    private val _users = MutableLiveData<List<User>>()
    val users : LiveData<List<User>>
        get() = _users

    suspend fun loadUsers() {
        val userList = UserApi.apiService.getUsers()
        Log.d("UserApiLog", userList.toString())

        _users.postValue(userList)
    }

}