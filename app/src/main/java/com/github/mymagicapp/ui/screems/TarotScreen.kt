package com.github.mymagicapp.ui.screems

import android.R.attr.padding
import android.R.attr.text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.mymagicapp.data.viewModel.TarotViewModel


@Composable
fun TarotScreen(
    onBackClick: () -> Unit,
    tarotViewModel: TarotViewModel = viewModel()
){
    

}