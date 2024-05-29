package com.example.liveappuserapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liveappuserapi.data.Repository
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    val repository = Repository()

    val users = repository.users

    fun loadUsers(){
       viewModelScope.launch {
           repository.loadUsers()
       }
    }



}