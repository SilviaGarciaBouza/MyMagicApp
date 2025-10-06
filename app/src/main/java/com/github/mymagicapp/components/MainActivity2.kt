package com.github.mymagicapp.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.R
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.github.mymagicapp.ui.theme.MyMagicAppTheme
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview


class MainActivity2 : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            MyMagicAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyComposable(modifier = Modifier.padding(innerPadding))
                }
            }

        }
    }
}


@Composable
fun MyComposable(modifier: Modifier) {
    ConstraintLayout(modifier.fillMaxSize()) {
        val(boxRed, boxBlue, boxYellow, boxMagenta, boxGreen) = createRefs()
val barrier = createEndBarrier(boxRed,boxBlue)
        Box(modifier.size(100.dp).background(Color.Red).constrainAs(boxRed){
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
        })
        Box(modifier.size(100.dp).background(Color.Cyan)){
            var n by rememberSaveable {mutableStateOf(0)}
            Text(text = "Pulsa:${n}", modifier=Modifier.clickable{n+=1})
        }
        Box(modifier.size(100.dp).background(Color.Yellow))
        Box(modifier.size(100.dp).background(Color.Blue))

    }
}

@Composable
fun MyText(modifier: Modifier){
    Text(text = "Hola",modifier=modifier)
}

@Composable
fun MyTextFieldParent(modifier: Modifier){
    var user by rememberSaveable { mutableStateOf("") }
    MyTextField(modifier, user){user = it}

}

@Composable
fun MyTextField(modifier: Modifier, user:String, onValueChange:(String)->Unit) {
    Column(modifier) {
        var text by rememberSaveable { mutableStateOf("") }
        TextField(
            "TextField",
            onValueChange = { onValueChange(it) },
            readOnly = true,
            placeholder = { Text(text = "name user") })
        TextField(
            "TextField",
            onValueChange = { onValueChange(it.replace("a", "")) })//impide escribir a

    }

}


@Composable
fun MyPasswordTextField(value:String, onValueChange:(String)->Unit){
    var passwordHidden by rememberSaveable { mutableStateOf(false) }
    TextField(
        value = value,
        onValueChange = {onValueChange(it)},
   //     keyboardOptions = keyboardOptions(keyboardType = KeyboardType.Password),
      //  visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
      //  trailingIcon = {Text(text = if(passwordHidden) "Mostrar" else "Ocultar", modifier=Modifier.clickable{passwordHidden=!passwordHidden}), modifier=Modifier.clickable{passwordHidden=!passwordHidden})}//se puede poner una imagen...
    )
}

@Composable
fun MyOutlinedTextField(modifier: Modifier, user:String, onValueChange:(String)->Unit) {
    Column(modifier) {
        var text by rememberSaveable { mutableStateOf("") }
        OutlinedTextField(
            "TextField",
            onValueChange = { onValueChange(it) },
            readOnly = true,
            placeholder = { Text(text = "name user") })
        BasicTextField(
            "TextField",
            onValueChange = { onValueChange(it.replace("a", "")) })//impide escribir a

    }

}
@Preview
@Composable
fun MyButton(){
    //enable=false
    Column {
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(20),
            modifier = Modifier.padding(10.dp),
            border = BorderStroke(3.dp, Color.Blue),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.Blue,
                disabledContainerColor = Color.Green,
                disabledContentColor = Color.Red
            )
        ) {
            Text(text = "Pulsa")

        }
        OutlinedButton(onClick = { /*TODO*/ }) { }
        TextButton(onClick = {}) {Text(text="Pulsa") }
        ElevatedButton(onClick = {}) {Text(text="Pulsa") }
        FilledTonalButton(onClick = {}) { }
    }

}

//@Composable
//fun MyImage() {
//    Image(
//        painter = painterResource(R.drawable.k),
//        contentDescription = "avatar image profile",
//        modifier = Modifier
//            .size(300.dp)
//            .clip(RoundedCornerShape(percent = 50))
//            .border(
//                width = 5.dp,
//                shape = CircleShape,
//                brush = Brush.linearGradient(colors=listOf(Color.Blue, Color.Red, Color.Green, Color.Yellow))
//            ),
//        contentScale = ContentScale.FillBounds
//    )
//}