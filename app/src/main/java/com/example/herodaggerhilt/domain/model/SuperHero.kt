package com.example.herodaggerhilt.domain.model

import com.example.herodaggerhilt.data.dto.Powerstats

data class SuperHero(
    val id: Int,
    val heroName: String,
    val fullName: String,
    val aliases: List<String>,
    val alterEgos: String,
    val groupAffiliation: String,
    val alignment: String,
    val imageSmall: String,
    val imageMedium: String,
    val powerStats: Powerstats,
    val occupation: String
)
