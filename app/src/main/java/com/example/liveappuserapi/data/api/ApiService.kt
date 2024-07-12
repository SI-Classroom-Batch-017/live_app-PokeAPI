package com.example.liveappuserapi.data.api

import com.example.liveappuserapi.data.model.PokemonDetailResponse
import com.example.liveappuserapi.data.model.PokemonListResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://pokeapi.co/api/v2/"


val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {

    @GET("pokemon")
    suspend fun loadPokemon() : PokemonListResponse

    @GET("pokemon/{name}")
    suspend fun loadPokemonDetail(@Path("name") pokemonName : String) : PokemonDetailResponse

}

object PokeApi {
    val apiService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}



