package com.example.veranoproyectoparcial1.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

// Data class que representa una orden
data class Order(val type: String, val size: String, val amount: String)

class TaskViewModel : ViewModel() {
    // Lista de órdenes
    val orders = mutableStateListOf<Order>()

    // Función para agregar una nueva orden a la lista
    fun addOrder(type: String, size: String, amount: String) {
        if (type.isNotBlank() && size.isNotBlank() && amount.isNotBlank()) {
            orders.add(Order(type, size, amount))
        }
    }

}
