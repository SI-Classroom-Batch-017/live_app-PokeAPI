package com.example.liveappuserapi.data.model

data class User (
    val id: Long,
    val name: String,
    val email: String,
    val gender: String,
    val status: String,

    //Extra Daten aus meiner App
    var liked: Boolean = false,
)


