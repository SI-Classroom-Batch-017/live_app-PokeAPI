package com.example.liveappuserapi



//const val BASE_URL = "https://gorest.co.in/public/v2/"
//const val TOKEN = "087bcbabb77fa0892598e704bb0bb441a9a33313da4e49692efb68b8b7e55bd2"
//
//val loggingInterceptor = HttpLoggingInterceptor().apply {
//    level = HttpLoggingInterceptor.Level.BODY
//}
//
//val client = OkHttpClient.Builder()
//    .addInterceptor(loggingInterceptor)
//    .build()
//
//val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()
//
//val retrofit = Retrofit.Builder()
//    .addConverterFactory(MoshiConverterFactory.create(moshi))
//    .baseUrl(BASE_URL)
//    .client(client)
//    .build()
//
//interface UserApiService {
//
//    @GET("users")
//    suspend fun getUsers(): List<User>
//
//    @POST("users")
//    suspend fun postUser(@Body user: User)
//}
//
//object UserApi {
//    val apiService: UserApiService by lazy { retrofit.create(UserApiService::class.java) }
//}