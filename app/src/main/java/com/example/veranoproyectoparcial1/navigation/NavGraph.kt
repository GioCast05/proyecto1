package com.example.veranoproyectoparcial1.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.veranoproyectoparcial1.ui.screens.CustomerScreen
import com.example.veranoproyectoparcial1.ui.screens.LoginScreen
import com.example.veranoproyectoparcial1.ui.screens.MainScreen
import com.example.veranoproyectoparcial1.ui.screens.MenuScreen
import com.example.veranoproyectoparcial1.ui.screens.OrderScreen
import com.example.veranoproyectoparcial1.ui.screens.OrdersScreen
import com.example.veranoproyectoparcial1.ui.screens.UsScreen
import com.example.veranoproyectoparcial1.viewModel.OrdersViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    val ordersViewModel: OrdersViewModel = viewModel()
    NavHost(navController = navController, startDestination = "LoginScreen") {
        composable("CustomerScreen") { CustomerScreen(navController, ordersViewModel) }
        composable("OrderScreen") { OrderScreen(navController, ordersViewModel) }
        composable("OrdersScreen") { OrdersScreen(navController, ordersViewModel) }
        composable("MenuScreen") { MenuScreen(navController) }
        composable("LoginScreen") { LoginScreen(navController) }
        composable("MainScreen") { MainScreen(navController) }
        composable("UsScreen") { UsScreen(navController) }
        }

}