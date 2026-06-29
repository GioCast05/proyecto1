package com.example.veranoproyectoparcial1.model

data class User (
    val username: String,
    val password: String
)

val usersList = listOf(
    User("admin", "admin"),
    User("Rodrigo", "123456789"),
    User("Karen", "abcdefghi")
)
