package com.example.veranoproyectoparcial1.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.veranoproyectoparcial1.ui.screens.CustomerScreen
import com.example.veranoproyectoparcial1.ui.screens.OrderScreen
import com.example.veranoproyectoparcial1.viewModel.TaskViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    val viewModel: TaskViewModel = viewModel()
    NavHost(navController = navController, startDestination = "CustomerScreen") {
        composable("CustomerScreen") { CustomerScreen(navController,viewModel) }
        composable("OrderScreen") { OrderScreen(navController,viewModel) }
        }

}