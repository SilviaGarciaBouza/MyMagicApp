package com.github.mymagicapp.components


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import com.github.mymagicapp.R
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import okhttp3.internal.threadName

// Eliminadas: import android.R y import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun myCircularProgressIndicatos(modifier: Modifier= Modifier){
    Column(modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        CircularProgressIndicator(
            Modifier.size(100.dp),
            color=Color.Red,
            strokeWidth=10.dp,
            trackColor=Color.Green,//segundocolor por detras
            strokeCap= StrokeCap.Round//punta redondeada
        )
        Spacer(modifier=Modifier.height(20.dp))
        LinearProgressIndicator(
            color=Color.Red,
            trackColor=Color.Green,//segundocolor por detras
            strokeCap= StrokeCap.Round)//punta redondeada
    }

}
@Preview(showBackground = true)
@Composable
fun myCircularProgressIndicatosAdvance(modifier: Modifier= Modifier) {
    var progress: Float by remember { mutableStateOf(0.5f) }
    var isLoading by remember { mutableStateOf(true) }

    val animateProgress by animateFloatAsState(targetValue = progress, animationSpec = tween(1000))
    Column(
        modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                progress = { animateProgress },//q sea parte hay q poner lo q sea pero tb lo q devuelve el num
                Modifier.size(100.dp),
                color = Color.Red,
                strokeWidth = 10.dp,
                trackColor = Color.Green,//segundocolor por detras
                strokeCap = StrokeCap.Round//punta redondeada
            )
            Spacer(modifier = Modifier.height(20.dp))
            LinearProgressIndicator(
                color = Color.Red,
                trackColor = Color.Green,//segundocolor por detras
                strokeCap = StrokeCap.Round
            )//punta redondeada
        }
        Row(Modifier.padding()) {
            Button(onClick = { progress -= 0.1f }) { Text(text = "<") }
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = { progress += 0.1f }) { Text(text = ">") }
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = { isLoading = !isLoading }) { Text(text = ">") }

        }
    }
}
//Lottie si quieres mas animaciones
//@Preview
//@Composable
//fun ProgressAnimation(modifier: Modifier = Modifier) {
//    // Carga la composición Lottie desde un recurso raw (R.raw.burger)
//    // Asegúrate de tener un archivo JSON de Lottie llamado 'burger.json' en res/raw/
//    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.burger))
//
//    Column(
//        modifier = modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        // Muestra la animación Lottie
//        LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever)
//    }
//}