package com.example.veranoproyectoparcial1.model

data class Pizza(
    val name: String,
    val priceSmall: Int,
    val priceLarge: Int
)

val pizzaMenu = listOf(
    Pizza("HAWAIHANA", 130, 150),
    Pizza("CUABANA", 120, 150),
    Pizza("PEPERONI", 140, 160)
)

fun calculatePrice(pizzaName: String, size: String, amount: Int): Int {
    val pizza = pizzaMenu.find { it.name == pizzaName } ?: return 0
    val unitPrice = if (size == "Grande") pizza.priceLarge else pizza.priceSmall
    return unitPrice * amount
}
