package com.example.herodaggerhilt.di

import com.example.herodaggerhilt.data.implementation.HeroRepositoryImpl
import com.example.herodaggerhilt.domain.repository.HeroRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    abstract fun bindHeroRepository(repository: HeroRepositoryImpl): HeroRepository
}