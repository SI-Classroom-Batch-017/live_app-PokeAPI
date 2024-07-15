package com.example.liveappuserapi

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liveappuserapi.data.Repository
import com.example.liveappuserapi.data.model.Pokemon
import com.example.liveappuserapi.data.model.PokemonDetailResponse
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    val repository = Repository()

    val pokemonList = repository.pokemonList

    private val _currentPokemon = MutableLiveData<PokemonDetailResponse>()
    val currentPokemon : LiveData<PokemonDetailResponse> = _currentPokemon

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

    fun setPokemon(pokemon: PokemonDetailResponse){
        _currentPokemon.postValue(pokemon)
    }

}