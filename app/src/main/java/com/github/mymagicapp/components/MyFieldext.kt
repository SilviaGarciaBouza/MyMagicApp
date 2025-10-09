package com.github.mymagicapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyBAse(text1:String, text2:String, oncl:()->Unit){
    var state by rememberSaveable { mutableStateOf("") }
    Column( modifier = Modifier
        .padding(horizontal = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text1)
        TextField(value=state,onValueChange = {state=it})
        Text(text2+state)
        Button(onClick = oncl) { }

    }

    }

@Composable
fun MyTip(){
    MyBAse("Calculate Tip", "Tip Amount", {})
}
