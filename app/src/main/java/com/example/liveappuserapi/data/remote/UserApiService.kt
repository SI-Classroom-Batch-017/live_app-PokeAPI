package com.example.liveappuserapi.data.remote

import com.example.liveappuserapi.data.model.User
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

const val BASE_URL = "https://gorest.co.in/public/v2/"
const val TOKEN = "087bcbabb77fa0892598e704bb0bb441a9a33313da4e49692efb68b8b7e55bd2"

val loggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

val client = OkHttpClient.Builder().addInterceptor { chain ->
    val newRequest = chain.request().newBuilder()
        .addHeader(
            "Authorization", "Bearer $TOKEN"
        ).build()
    chain.proceed(newRequest)
}.addInterceptor(loggingInterceptor)
    .build()

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface UserApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

    @POST("users")
    suspend fun postUser(@Body user: User)
}

object UserApi {
    val apiService: UserApiService by lazy { retrofit.create(UserApiService::class.java) }
}



