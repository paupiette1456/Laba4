package com.paupiette.laba4.ui.tasks

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class GenerateViewModel : ViewModel() {
    private val _result = mutableStateOf("")
    val result: State<String> = _result

    fun generateNumber() {
        viewModelScope.launch {
            val randomNumber = generateRandomNumber()
            _result.value = "Сгенерированное число: $randomNumber"
        }
    }

    private suspend fun generateRandomNumber(): Int {
        delay(100 * Random.nextInt(1, 10).toLong())
        return Random.nextInt(1, 10)
    }
}
