package com.example.veranoproyectoparcial1.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.veranoproyectoparcial1.ui.screens.TaskCustomerScreen
import com.example.veranoproyectoparcial1.viewModel.TaskViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    val viewModel: TaskViewModel = viewModel()
    NavHost(navController = navController, startDestination = "TaskCustomerScreen") {
        composable("TaskCustomerScreen") {
            TaskCustomerScreen(viewModel)
        }
        }
}