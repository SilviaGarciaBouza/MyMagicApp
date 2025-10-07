package com.github.mymagicapp.data.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.github.mymagicapp.data.Animal
import com.github.mymagicapp.data.ZodiacSign
import com.github.mymagicapp.data.animalTestQuestions
import com.github.mymagicapp.data.calculateSpiritAnimal
import com.github.mymagicapp.data.getImagehoroscope
import com.github.mymagicapp.data.gethoroscopReadingRandon

open class ViewModel: ViewModel() {


    // ANIMAL ESPIRITUAL


    var animalSelected by mutableStateOf<Animal?>(null)
        private set


    var currentQuestionIndex by mutableStateOf(0)
        private set


    private val animalScores = mutableStateMapOf<Animal, Int>()




    fun answerQuestion(animal: Animal) {
        animalScores[animal] = animalScores.getOrDefault(animal, 0) + 1


        if (currentQuestionIndex < animalTestQuestions.size - 1) {
            currentQuestionIndex++
        } else {
            assignSpiritAnimal()
        }
    }


    private fun assignSpiritAnimal() {
        animalSelected = calculateSpiritAnimal(animalScores)
    }


    fun resetTest() {
        currentQuestionIndex = 0
        animalScores.clear()

    }


    //  HORÓSCOPO


    var signSelected by mutableStateOf<ZodiacSign?>(null)
        private set

    var sentenceHoroscopeDay by mutableStateOf<String?>(null)
        private set

var imageHoroscope by mutableStateOf<Int>(1)
    fun seleccionarSigno(signo: ZodiacSign) {
        signSelected = signo
        generHoroscopOfDay(signo)
    }

    private fun generHoroscopOfDay(signo: ZodiacSign) {
        sentenceHoroscopeDay = gethoroscopReadingRandon(signo)
    }

    private fun getHoroscopImage(signo: ZodiacSign){
        imageHoroscope= getImagehoroscope(signo)
    }


    fun seleccionarAnimal(animal: Animal) {
        animalSelected = animal
    }
}