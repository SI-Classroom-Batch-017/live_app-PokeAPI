package com.example.liveappuserapi.data.model

data class PokemonDetailResponse (
    val sprites : Sprites,
    val name: String,
    val id: Int,
)


data class Sprites(
    val front_default : String,
    val front_shiny: String
)