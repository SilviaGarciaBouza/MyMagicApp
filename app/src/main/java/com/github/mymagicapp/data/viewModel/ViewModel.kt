package com.github.mymagicapp.data.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.github.mymagicapp.data.Animal
import com.github.mymagicapp.data.ZodiacSign
import com.github.mymagicapp.data.gethoroscopReadingRandon

class ViewModel: ViewModel() {
    var animalSelected by mutableStateOf<Animal?>(null)
    private set

    var signSelected by mutableStateOf<ZodiacSign?>(null)
        private set

    var sentenceHoroscopeDay by mutableStateOf<String?>(null)
        private set



    fun seleccionarAnimal(animal: Animal) {
        animalSelected = animal
    }


    fun seleccionarSigno(signo: ZodiacSign) {
        signSelected = signo
        generHoroscopOfDay(signo)
    }

    private fun generHoroscopOfDay(signo: ZodiacSign) {
        sentenceHoroscopeDay = gethoroscopReadingRandon(signo)
    }
}