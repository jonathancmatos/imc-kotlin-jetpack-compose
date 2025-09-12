package com.devjonathancosta.imc_calculator.core.router

import ResultView
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devjonathancosta.imc_calculator.ui.views.HomeView

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeView(navController = navController) }
        composable("result") { ResultView(navController = navController) }
    }
}