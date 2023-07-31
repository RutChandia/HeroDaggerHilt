package com.example.herodaggerhilt.data.network

import com.example.herodaggerhilt.data.dto.HeroDTO
import retrofit2.http.GET

interface ApiServiceHero {
    @GET("all.json")
    suspend fun getHeroes(): List<HeroDTO>
}