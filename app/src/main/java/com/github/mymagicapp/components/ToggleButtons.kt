package com.github.mymagicapp.components

import android.R.attr.checked
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MySwitch(modifier:Modifier = Modifier){
    var switchState by rememberSaveable { mutableStateOf(true)}
    Box(modifier=modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Switch (checked=switchState, onCheckedChange = {switchState=it})
    }
}
@Preview
@Composable
fun MySwitchBox(modifier:Modifier = Modifier){
    var switchState by rememberSaveable { mutableStateOf(true)}
    Box(modifier=modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Checkbox (checked=switchState, onCheckedChange = {switchState=it})
    }

}