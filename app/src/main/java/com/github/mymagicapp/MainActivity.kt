package com.github.mymagicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.mymagicapp.data.viewModel.PalmReadingViewModel
import com.github.mymagicapp.data.viewModel.TarotViewModel
import com.github.mymagicapp.data.viewModel.ViewModel
import com.github.mymagicapp.ui.screems.AnimalTestScreen
import com.github.mymagicapp.ui.screems.HomeScreen
import com.github.mymagicapp.ui.screems.HoroscopeScreen
import com.github.mymagicapp.ui.PalmReadingScreen
import com.github.mymagicapp.ui.navigation.Screen
import com.github.mymagicapp.ui.screems.TarotScreen
import com.github.mymagicapp.ui.theme.MyMagicAppTheme






class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyMagicAppTheme {
                val mainViewModel: ViewModel = viewModel()
                val palmViewModel: PalmReadingViewModel = viewModel()
                val tarotViewModel: TarotViewModel= viewModel()

                AppNavigation(
                    mainViewModel = mainViewModel,
                    palmReadingViewModel = palmViewModel,
                    tarotViewModel = tarotViewModel
                )
            }
        }
    }
}

@Composable
fun AppNavigation(mainViewModel: ViewModel, palmReadingViewModel: PalmReadingViewModel, tarotViewModel: TarotViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {

        // HOMESCREEN
        composable(Screen.Home.route) {
            HomeScreen(
                viewModel = mainViewModel,
                onStartTestClick = { navController.navigate(Screen.AnimalTest.route) },
                onHoroscopeClick = { navController.navigate(Screen.Horoscope.route) },
                onPalmReadingClick = { navController.navigate(Screen.PalmReading.route) },
                onTarotClick = {navController.navigate(Screen.Tarot.route)}
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
                palmReadingViewModel = palmReadingViewModel,
                onBackClick = { navController.popBackStack() },
            )
        }
        //taROT SREEN
        composable(Screen.Tarot.route){
            TarotScreen(
                tarotViewModel = tarotViewModel,
                onBackClick = { navController.popBackStack() }
            )
        }
    }

}