package com.example.herodaggerhilt.domain.repository

import com.example.herodaggerhilt.data.network.ApiResponseState
import com.example.herodaggerhilt.domain.model.SuperHero

interface HeroRepository {
    suspend fun getSuperHero() : ApiResponseState<List<SuperHero>>
}