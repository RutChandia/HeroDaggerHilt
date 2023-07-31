package com.example.herodaggerhilt.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.herodaggerhilt.data.network.ApiResponseState
import com.example.herodaggerhilt.domain.model.SuperHero
import com.example.herodaggerhilt.domain.repository.HeroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HeroViewModel @Inject constructor(
    private val repository: HeroRepository
) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _superHeroesMap = MutableStateFlow<Map<Int, SuperHero>>(emptyMap())
    val superHeroesMap: StateFlow<Map<Int, SuperHero>> = _superHeroesMap

    init {
        getSuperHeroes()
    }

    private fun getSuperHeroes() {
        _isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getSuperHero()
            withContext(Dispatchers.Main) {
                if (response is ApiResponseState.Success) {
                    updateSuperHeroMap(response.data)
                }
                _isLoading.value = false
            }
        }
    }

    private fun updateSuperHeroMap(superHeroList: List<SuperHero>) {
        // Convierte la lista en un map con el ID como clave
        val superHeroMap = superHeroList.associateBy { it.id }
        _superHeroesMap.value = superHeroMap
    }
}