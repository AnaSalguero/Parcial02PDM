package com.pdm0126.parcial2rankeduca.Screens.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm0126.parcial2rankeduca.Data.Repository.RestaurantApiRepository
import com.pdm0126.parcial2rankeduca.Data.Repository.RestaurantRepository
import com.pdm0126.parcial2rankeduca.Data.Model.Option
import com.pdm0126.parcial2rankeduca.Model.RestaurantOption
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel: ViewModel() {
    private val restRepository : RestaurantRepository = RestaurantApiRepository()
    private val _restOpt = MutableStateFlow<List<RestaurantOption>>(emptyList())
    val restOpt = _restOpt.asStateFlow()

    private val _loading = MutableStateFlow<Boolean>(true)
    val loading = _loading.asStateFlow()

    private val _refresh = MutableStateFlow<Boolean>(false)
    val refresh = _refresh.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    init {
        loadRestaurants()
    }

    fun loadRestaurants(){
        viewModelScope.launch {
            _error.value = null
            _loading.value = true

            restRepository.getRestaurantOptions().
            onSuccess {
                    res ->
                _restOpt.value = res
            }.onFailure {
                    error ->
                _error.value = "Parece que ha habido un error, por que no intentas de nuevo? error $error"
            }
            _loading.value = false
        }
    }

    fun refreshPosts(){
        viewModelScope.launch {
            _error.value = null
            _refresh.value = true

            restRepository.getRestaurantOptions().onSuccess {
                    res ->
                _restOpt.value = res
            }.onFailure {
                    error ->
                _error.value = "Parece que ha habido un error, por que no intentas de nuevo?"
            }
            _refresh.value = false
        }
    }
}