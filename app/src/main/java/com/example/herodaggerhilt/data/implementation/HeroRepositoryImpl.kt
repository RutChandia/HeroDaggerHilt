package com.example.herodaggerhilt.data.implementation

import com.example.herodaggerhilt.data.network.ApiResponseState
import com.example.herodaggerhilt.data.network.ApiServiceHero
import com.example.herodaggerhilt.data.network.doNetworkCall
import com.example.herodaggerhilt.domain.mapper.HeroMapper
import com.example.herodaggerhilt.domain.repository.HeroRepository
import com.example.herodaggerhilt.domain.model.SuperHero
import javax.inject.Inject

class HeroRepositoryImpl @Inject constructor(
    private val apiServiceHero: ApiServiceHero
): HeroRepository {
    override suspend fun getSuperHero(): ApiResponseState<List<SuperHero>> {
        return doNetworkCall {
            val response = apiServiceHero.getHeroes()
            val mapper = HeroMapper()
            mapper.dtoToSuperHero(response)
        }
    }
}