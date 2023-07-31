package com.example.herodaggerhilt.domain.mapper

import com.example.herodaggerhilt.domain.model.SuperHero
import com.example.herodaggerhilt.data.dto.HeroDTO
import com.example.herodaggerhilt.data.dto.Powerstats

class HeroMapper {
    fun dtoToSuperHero(listDTO: List<HeroDTO>): List<SuperHero> {
        return listDTO.map { heroDTO ->
            SuperHero(
                id = heroDTO.id,
                heroName = heroDTO.name,
                fullName = heroDTO.biography.fullName,
                aliases = heroDTO.biography.aliases,
                alterEgos = heroDTO.biography.alterEgos,
                groupAffiliation = heroDTO.connections.groupAffiliation,
                alignment = heroDTO.biography.alignment,
                imageSmall = heroDTO.images.sm,
                imageMedium = heroDTO.images.md,
                powerStats = Powerstats(
                    combat = heroDTO.powerstats.combat,
                    durability = heroDTO.powerstats.durability,
                    intelligence = heroDTO.powerstats.intelligence,
                    power = heroDTO.powerstats.power,
                    speed = heroDTO.powerstats.speed,
                    strength = heroDTO.powerstats.strength
                ),
                occupation = heroDTO.work.occupation
            )
        }
    }
}