package com.arash.altafi.ktorsample3

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arash.altafi.ktorsample3.data.ktor.RabbitsApiKtor
import com.arash.altafi.ktorsample3.data.retrofit.Rabbit
import com.arash.altafi.ktorsample3.data.retrofit.RabbitsApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val api: RabbitsApi,
    private val apiKtor: RabbitsApiKtor
) : ViewModel() {

    private val _state = mutableStateOf(RabbitState())
    val state: State<RabbitState> = _state

    private val _stateKtor = mutableStateOf(RabbitStateKtor())
    val stateKtor: State<RabbitStateKtor> = _stateKtor

    init {
        getRandomRabbit()
        getRandomRabbitKtor()
    }

    fun getRandomRabbit() {
        viewModelScope.launch {
            try {
                _state.value = state.value.copy(isLoading = true)
                _state.value = state.value.copy(
                    rabbit = api.getRandomRabbit(),
                    isLoading = false
                )
            } catch(e: Exception) {
                Log.e("MainViewModel", "getRandomRabbit: ", e)
                _state.value = state.value.copy(isLoading = false)
            }
        }
    }

    fun getRandomRabbitKtor() {
        viewModelScope.launch {
            try {
                _stateKtor.value = stateKtor.value.copy(isLoading = true)
                _stateKtor.value = stateKtor.value.copy(
                    rabbit = apiKtor.getRandomRabbitKtor(),
                    isLoading = false
                )
            } catch(e: Exception) {
                Log.e("MainViewModel", "getRandomRabbitKtor: ", e)
                _stateKtor.value = stateKtor.value.copy(isLoading = false)
            }
        }
    }

    data class RabbitState(
        val rabbit: Rabbit? = null,
        val isLoading: Boolean = false
    )

    data class RabbitStateKtor(
        val rabbit: com.arash.altafi.ktorsample3.data.ktor.Rabbit? = null,
        val isLoading: Boolean = false
    )
}