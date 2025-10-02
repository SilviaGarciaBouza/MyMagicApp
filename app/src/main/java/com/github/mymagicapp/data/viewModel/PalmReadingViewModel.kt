package com.github.mymagicapp.data.viewModel



import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.mymagicapp.data.getRandomPalmReading
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class PalmReadingViewModel : ViewModel() {


    enum class PalmScanState { IDLE, SCANNING, RESULT }

    var palmScanState by mutableStateOf(PalmScanState.IDLE)
        private set

    //  lectura definitiva
    private var permanentPalmReading: String? = null

    val hasPermanentReading: Boolean
        get() = permanentPalmReading != null
    var palmReadingResult by mutableStateOf<String?>(null)
        private set


    fun startPalmScan() {
        //  ya tenemos una lectura , actualizamos el estado
        if (permanentPalmReading != null) {
            palmScanState = PalmScanState.RESULT
            palmReadingResult = permanentPalmReading
            return
        }

        // es la primera vez  iniciamos el proceso de escaneo.
        if (palmScanState == PalmScanState.IDLE) {
            palmScanState = PalmScanState.SCANNING
            palmReadingResult = null

            // asignar la lectura permanente
            permanentPalmReading = getRandomPalmReading()

            viewModelScope.launch {
                // Simula el proceso de escaneo
                delay(TimeUnit.SECONDS.toMillis(3))

                // Transición al estado de resultado
                palmReadingResult = permanentPalmReading
                palmScanState = PalmScanState.RESULT
            }
        }
    }
}