package com.github.mymagicapp.ui.screems

import android.content.ClipData
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import com.github.mymagicapp.data.Animal

//@Composable
//fun MyPlayAnimals() {
//    var items by rememberSaveable { mutableStateOf(listOf<Animal>()) }
//    LazyRow() {
//        items.forEach { item ->
//            {
//                Image(
//                    painter = painterResource(item.imageAnimal),
//                    contentDescription = item.nameAnimal
//                )
//            }
//        }
//
//    }
//}