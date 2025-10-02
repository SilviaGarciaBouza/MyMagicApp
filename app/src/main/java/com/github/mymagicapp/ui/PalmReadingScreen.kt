package com.github.mymagicapp.ui

import androidx.compose.ui.platform.LocalInspectionMode


import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.mymagicapp.data.viewModel.PalmReadingViewModel
import com.google.accompanist.permissions.*

@OptIn(ExperimentalPermissionsApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PalmReadingScreen(
    onBackClick: () -> Unit,
    palmReadingViewModel: PalmReadingViewModel = viewModel()
) {
    val cameraPermissionState = rememberPermissionState(
        Manifest.permission.CAMERA
    )
    //si ya tne resultado ya esta
    if (cameraPermissionState.status.isGranted) {
        LaunchedEffect(Unit) {
            palmReadingViewModel.startPalmScan()
        }
    }
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
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when {
                // si dn el permiso da camara :
                cameraPermissionState.status.isGranted -> {
                    PalmScanContent(
                        viewModel = palmReadingViewModel,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f) //cuadrado
                    )
                }

                // no hay permiso:
                cameraPermissionState.status.shouldShowRationale -> {
                    PermissionRationale(
                        message = "Necesitamos acceso a tu cámara para poder 'leer' las líneas de tu mano. Es esencial para esta funcionalidad.",
                        onRequesPermission = cameraPermissionState::launchPermissionRequest
                    )
                }

                // primera vez o permiso dnegado
                else -> {
                    PermissionRationale(
                        message = "El acceso a la cámara es necesario para la función de lectura de mano. Por favor, concédele permiso.",
                        onRequesPermission = cameraPermissionState::launchPermissionRequest
                    )
                }
            }
        }
    }
}

@Composable
fun PalmScanContent(
    viewModel: PalmReadingViewModel,
    modifier: Modifier
) {
    val scanState = viewModel.palmScanState
    val readingResult = viewModel.palmReadingResult
    val isPermanentReadingAvailable = viewModel.hasPermanentReading

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // mostrams la cámara
        CameraPreview(modifier = modifier)

        Spacer(modifier = Modifier.height(24.dp))


        when (scanState) {
            PalmReadingViewModel.PalmScanState.IDLE -> {
                // si ya hay un resultado permanente, mostramos l result
                if (isPermanentReadingAvailable) {

                    ResultCard(
                        title = "Tu Lectura de Mano Única (Cargada)",
                        result = viewModel.palmReadingResult ?: "Cargando...",
                    )
                } else {
                    // primra vez
                    Text(
                        "Coloca tu mano y presiona 'Escanear' para ver tu destino.",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = viewModel::startPalmScan) {
                        Text("¡Escanear mi Mano! 🔮")
                    }
                }
            }
            PalmReadingViewModel.PalmScanState.SCANNING -> {
                // Eel progreso.
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "Analizando líneas místicas... Este es el único escaneo permitido.",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            PalmReadingViewModel.PalmScanState.RESULT -> {
                // muestra la lectura permanente.
                ResultCard(
                    title = "Tu Lectura de Mano Única",
                    result = readingResult ?: "Error al obtener la lectura.",
                )
            }
        }
    }
}


@Composable
fun ResultCard(title: String, result: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.tertiary
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = result,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.height(24.dp))

        }
    }
}


@Composable
fun CameraPreview(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }

    AndroidView(
        modifier = modifier.clip(MaterialTheme.shapes.medium),
        factory = { ctx ->
            val previewView = PreviewView(ctx).apply {
                this.scaleType = PreviewView.ScaleType.FILL_CENTER
            }

            val executor = ContextCompat.getMainExecutor(ctx)
            cameraProviderFuture.addListener({
                val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()
                val preview = Preview.Builder()
                    .build()
                    .also {
                        it.setSurfaceProvider(previewView.surfaceProvider)
                    }

                // usaremos la camara de atras
                val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

                try {
                    // desvincula cualquier  uso previo
                    cameraProvider.unbindAll()

                    // vincula el caso de uso de preview a la cámara y al ciclo de vida
                    cameraProvider.bindToLifecycle(
                        lifecycleOwner,
                        cameraSelector,
                        preview
                    )
                } catch (exc: Exception) {
                }

            }, executor)
            previewView
        }
    )
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionRationale(
    message: String,
    onRequesPermission: () -> Unit
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Permiso de Cámara Requerido",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.error
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = message,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onRequesPermission) {
                Text("Conceder Permiso")
            }
            // si deniegas sugiere ir a settings
            if (!LocalInspectionMode.current && !rememberPermissionState(Manifest.permission.CAMERA).status.shouldShowRationale) {
                Spacer(modifier = Modifier.height(12.dp))
                TextButton(
                    onClick = {
                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                            data = Uri.fromParts("package", context.packageName, null)
                        }
                        context.startActivity(intent)
                    }
                ) {
                    Text("Abrir Ajustes de la Aplicación")
                }
            }
        }
    }
}