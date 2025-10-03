package com.github.mymagicapp.ui.screems

import android.R.attr.padding
import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.constraintlayout.compose.ConstraintSet
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.mymagicapp.data.viewModel.TarotViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TarotScreen(
    onBackClick: () -> Unit,
    tarotViewModel: TarotViewModel = viewModel()
){
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
    ){padding->
        Column(modifier = Modifier) {
            Card {
                Image(contentScale = ContentScale.Fit)
            }
            Card {  }
            Card {  }

        }

    }

}