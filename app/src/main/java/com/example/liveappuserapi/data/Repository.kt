package com.example.liveappuserapi.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.liveappuserapi.data.api.PokeApi
import com.example.liveappuserapi.data.model.Pokemon
import com.example.liveappuserapi.data.model.PokemonDetailResponse

class Repository {

    // 1 - LiveData die die Daten enthält im Format was für das UI gut ist
    private val _pokemonList = MutableLiveData<List<PokemonDetailResponse>>()
    val pokemonList : LiveData<List<PokemonDetailResponse>> = _pokemonList



    // 2 - Funktion die die Daten lädt und in die LiveData postet
    suspend fun loadPokemon() {

        val response = PokeApi.apiService.loadPokemon()

        //Liste von dem Datentyp der LiveData, in diesem Format brauchen wir die Daten
        val resultList = mutableListOf<PokemonDetailResponse>()

        //Für alle Pokemon
        for (pokemon in response.results){

            //Lade die Details für dieses Pokemon
            val pokemonDetail = PokeApi.apiService.loadPokemonDetail(pokemon.name)

            //Füge sie der Liste hinzu
            resultList.add(pokemonDetail)

            //Poste die aktualisierte List. Da das noch in der Schleife passiert,
            //aktualisiert sich die Liste für alle Pokemon einzeln
            _pokemonList.postValue(resultList)
        }


//Test für loadPokemonDetail
//        val firstPokemon = response.results.first()
//        val detailResponse = PokeApi.apiService.loadPokemonDetail(firstPokemon.name)
//        Log.d("FirstPokemonDetail", detailResponse.toString())




    }



}