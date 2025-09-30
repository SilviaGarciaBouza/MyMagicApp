package com.github.mymagicapp.data.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.github.mymagicapp.data.Animal

class ViewModel: ViewModel() {
    var animalSelected by mutableStateOf<Animal?>(null)
    private set
}