package com.example.veranoproyectoparcial1.model

data class Pizza(
    val name: String,
    val price: String,
    val weight: String
)

val pizzaMenu = listOf(
    Pizza("HAWAIHANA", "$130CH", "150G"),
    Pizza("CUABANA", "$120CH", "150G"),
    Pizza("PEPERONI", "$140CH", "160G")
)
