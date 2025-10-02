package com.github.mymagicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.mymagicapp.data.viewModel.PalmReadingViewModel
import com.github.mymagicapp.data.viewModel.ViewModel
import com.github.mymagicapp.ui.AnimalTestScreen
import com.github.mymagicapp.ui.HomeScreen
import com.github.mymagicapp.ui.HoroscopeScreen
import com.github.mymagicapp.ui.PalmReadingScreen
import com.github.mymagicapp.ui.navigation.Screen
import com.github.mymagicapp.ui.theme.MyMagicAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMagicAppTheme {
                val mainViewModel: ViewModel = viewModel()
                val palmViewModel: PalmReadingViewModel = viewModel()

                AppNavigation(
                    mainViewModel = mainViewModel,
                    palmReadingViewModel = palmViewModel
                )
            }
        }
    }
}

@Composable
fun AppNavigation(mainViewModel: ViewModel, palmReadingViewModel: PalmReadingViewModel) {    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {

        // HOMESCREEN
        composable(Screen.Home.route) {
            HomeScreen(
                viewModel = mainViewModel,
                onStartTestClick = { navController.navigate(Screen.AnimalTest.route) },
                onHoroscopeClick = { navController.navigate(Screen.Horoscope.route) },
                onPalmReadingClick = { navController.navigate(Screen.PalmReading.route) }
            )
        }

        // ANIMAL TEST SCREEN
        composable(Screen.AnimalTest.route) {
            AnimalTestScreen(
                viewModel = mainViewModel,
                onBackClick = { navController.popBackStack() },
                onFinishTest = {
                    navController.popBackStack(Screen.Home.route, inclusive = false)
                }
            )
        }

        // HOROSCOPE SCREEN
        composable(Screen.Horoscope.route) {
            HoroscopeScreen(
                viewModel = mainViewModel,
                onBackClick = { navController.popBackStack() }
            )
        }

        // PALM READING SCREEN
        composable(Screen.PalmReading.route) {
            PalmReadingScreen(
                onBackClick = { navController.popBackStack() },
                palmReadingViewModel = palmReadingViewModel
            )
        }
    }

}