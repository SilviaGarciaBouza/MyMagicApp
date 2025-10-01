package com.github.mymagicapp.ui


import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.mymagicapp.data.Animal
import com.github.mymagicapp.data.animalTestQuestions
import com.github.mymagicapp.data.viewModel.ViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalTestScreen(
    viewModel: ViewModel,
    onBackClick: () -> Unit,
    onFinishTest: () -> Unit
) {
    val totalQuestions = animalTestQuestions.size

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Descubre tu Animal Espiritual") },
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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            if (viewModel.animalSelected == null) {
                TestInProgressContent(
                    viewModel = viewModel,
                    totalQuestions = totalQuestions
                )
            } else {
                TestResultContent(
                    animal = viewModel.animalSelected!!,
                    onFinishTest = onFinishTest
                )
            }
        }
    }
}

@Composable
fun TestInProgressContent(viewModel: ViewModel, totalQuestions: Int) {
    val currentQuestion = animalTestQuestions[viewModel.currentQuestionIndex]

    LinearProgressIndicator(
        progress = (viewModel.currentQuestionIndex + 1) / totalQuestions.toFloat(),
        modifier = Modifier
            .fillMaxWidth()
            .height(8.dp)
    )
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "Pregunta ${viewModel.currentQuestionIndex + 1} de $totalQuestions",
        style = MaterialTheme.typography.titleSmall
    )

    Spacer(modifier = Modifier.height(32.dp))

    Text(
        text = currentQuestion.text,
        style = MaterialTheme.typography.headlineSmall,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 24.dp)
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        currentQuestion.answers.forEach { answer ->
            Button(
                onClick = { viewModel.answerQuestion(answer.pointsToAnimal) },
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(20.dp)
            ) {
                Text(
                    text = answer.text,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun TestResultContent(animal: Animal, onFinishTest: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "¡Descubierto!",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Tu Animal Espiritual es el",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = animal.nameAnimal,
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = animal.infoAnimal,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(onClick = onFinishTest) {
                Text("Volver al Inicio")
            }
        }
    }
}