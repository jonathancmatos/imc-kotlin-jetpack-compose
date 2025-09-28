package com.devjonathancosta.imc_calculator.core.router

import ResultView
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.devjonathancosta.imc_calculator.ui.views.HomeView

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeView(navController = navController) }
        composable(
            route = "result/{imc}",
            arguments = listOf(navArgument("imc") { type = NavType.FloatType })
        ) { backStackEntry ->
            val imc = backStackEntry.arguments?.getFloat("imc") ?: 0f
            ResultView(navController = navController, imc = imc)
        }
    }
}