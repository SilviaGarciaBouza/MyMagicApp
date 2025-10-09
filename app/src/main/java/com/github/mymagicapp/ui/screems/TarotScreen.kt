package com.github.mymagicapp.ui.screems

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.mymagicapp.R
import com.github.mymagicapp.data.viewModel.TarotViewModel

//TODO:emparejar animales spiritles juegs
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TarotScreen(
    onBackClick: () -> Unit,
    tarotViewModel: TarotViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Lectura de Mano") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var myImageCardTap by rememberSaveable { mutableStateOf(true) }
            var myImageCardTap2 by rememberSaveable { mutableStateOf(true) }
            var myImageCardTap3 by rememberSaveable { mutableStateOf(true) }

            val rotation by animateFloatAsState(
                targetValue = if (myImageCardTap) 0f else 180f,
                animationSpec = tween(durationMillis = 500),
            )
            val rotation2 by animateFloatAsState(
                targetValue = if (myImageCardTap2) 0f else 180f,
                animationSpec = tween(durationMillis = 500),
            )
            val rotation3 by animateFloatAsState(
                targetValue = if (myImageCardTap3) 0f else 180f,
                animationSpec = tween(durationMillis = 500),
            )

            val currentImageId = if (rotation <= 90f) R.drawable.lobo else R.drawable.kakapo
            val currentImageId2 = if (rotation2 <= 90f) R.drawable.lobo else R.drawable.kakapo
            val currentImageId3 = if (rotation3 <= 90f) R.drawable.lobo else R.drawable.kakapo


            Spacer(modifier = Modifier
                .height(24.dp)
                .fillMaxWidth())

            Card(modifier = Modifier
                .weight(1f)
                .graphicsLayer {

                    rotationY = rotation
                }
                .clickable {
                    myImageCardTap = false//!myImageCardTap
                }) {

                Image(
                    painter = painterResource(id = currentImageId),
                    contentScale = ContentScale.Fit,
                    contentDescription = "Image primera carta",
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier
                .height(24.dp)
                .fillMaxWidth())
            Card(modifier = Modifier
                .weight(1f)
                .graphicsLayer {

                    rotationY = rotation2
                }
                .clickable {
                    myImageCardTap2 = false
                }) {
                Image(
                    painter = painterResource(id = currentImageId2),
                    contentScale = ContentScale.Fit,
                    contentDescription = "Image segunda carta",
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier
                .height(24.dp)
                .fillMaxWidth())

            Card(modifier = Modifier
                .weight(1f)
                .graphicsLayer {

                    rotationY = rotation3
                }
                .clickable {
                    myImageCardTap3 = false //!myImageCardTap3
                }) {
                Image(
                    painter = painterResource(id = currentImageId3),
                    contentScale = ContentScale.Fit,
                    contentDescription = "Image tercera carta",
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier
                .height(24.dp)
                .fillMaxWidth())
        }

    }

}