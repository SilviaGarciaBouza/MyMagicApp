package com.github.mymagicapp.ui


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.mymagicapp.data.ZodiacSign
import com.github.mymagicapp.data.viewModel.ViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HoroscopeScreen(
    viewModel: ViewModel,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Tu Horóscopo del Día") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            //  seleccionar l signo
            SignSelectionGrid(
                selectedSign = viewModel.signSelected,
                onSignSelected = viewModel::seleccionarSigno
            )

            Spacer(modifier = Modifier.height(24.dp))

            // mostrar  result
            HoroscopeReadingCard(
                sign = viewModel.signSelected,
                reading = viewModel.sentenceHoroscopeDay
            )
        }
    }
}

@Composable
fun SignSelectionGrid(
    selectedSign: ZodiacSign?,
    onSignSelected: (ZodiacSign) -> Unit
) {
    // 12 signos  4 columnas
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        contentPadding = PaddingValues(4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.heightIn(max = 250.dp)
    ) {
        items(ZodiacSign.entries.toTypedArray()) { sign ->
            val isSelected = sign == selectedSign

            Card(
                modifier = Modifier
                    .aspectRatio(1f) // Lo hace cuadrado
                    .clickable { onSignSelected(sign) },
                colors = CardDefaults.cardColors(
                    containerColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = if (isSelected) 4.dp else 1.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = sign.nameSign,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = sign.periodSign,
                        style = MaterialTheme.typography.labelSmall,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun HoroscopeReadingCard(sign: ZodiacSign?, reading: String?) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer
        )
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            if (sign == null) {
                Text(
                    text = "Selecciona tu signo zodiacal para ver tu predicción de hoy.",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            } else {
                Text(
                    text = "Horóscopo para ${sign.nameSign}:",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.tertiary
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = reading ?: "Cargando predicción...",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}