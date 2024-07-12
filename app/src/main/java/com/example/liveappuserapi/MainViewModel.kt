package com.example.liveappuserapi

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liveappuserapi.data.Repository
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    val repository = Repository()

    val pokemonList = repository.pokemonList

    init {
        loadPokemonList()
    }

    fun loadPokemonList() {

        viewModelScope.launch {
            try {
                repository.loadPokemon()
            } catch (ex : Exception){
                Log.e("PokeApiCall", ex.message.toString())
            }
        }


    }

}