package com.github.mymagicapp.ui.screems

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.mymagicapp.data.viewModel.ViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.github.mymagicapp.data.Animal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: ViewModel,
    onStartTestClick: () -> Unit,
    onHoroscopeClick: () -> Unit,
    onPalmReadingClick: () -> Unit
) {
    Scaffold(topBar = { TopAppBar(title = { Text("My Magic App") }) }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            AnimalStatus(
                animal = viewModel.animalSelected,
                onStartTestClick = onStartTestClick
            )

            Spacer(modifier = Modifier.height(32.dp))


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = onHoroscopeClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Ver mi Horóscopo")
                }
                Button(
                    onClick = onPalmReadingClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Leer mi Mano")
                }
            }
        }
    }
}

@Composable
fun AnimalStatus(animal: Animal?, onStartTestClick: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (animal != null) {
                Image(
                    painter = painterResource(id = animal.imageAnimal),
                    contentDescription = "Imagen de ${animal.nameAnimal}",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Tu Animal Espiritual es:",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = animal.nameAnimal,
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = animal.infoAnimal,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 8.dp)
                )
            } else {
                Text(
                    text = "Aún no tienes un Animal Espiritual asignado.",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = onStartTestClick) {
                    Text("¡Descubre mi Animal Espiritual!")
                }
            }
        }
    }
}