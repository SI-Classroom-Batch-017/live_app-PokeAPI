package com.example.liveappuserapi.data.remote

import com.example.liveappuserapi.data.model.User
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://gorest.co.in/public/v2/"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface UserApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

}

object UserApi {
    val apiService: UserApiService by lazy { retrofit.create(UserApiService::class.java) }
}



