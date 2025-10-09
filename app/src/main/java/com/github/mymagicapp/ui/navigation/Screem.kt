package com.github.mymagicapp.ui.navigation


sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object AnimalTest : Screen("animal_test")
    data object Horoscope : Screen("horoscope")
    data object PalmReading : Screen("palm_reading")
    data object Tarot : Screen("tarot")
    data object PlayAnimal : Screen("play_animal")

}