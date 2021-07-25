package com.example.game.pojo.models

data class RegisterModel(
    val email: String,
    val firstName: String,
    val lastName: String = "",
    val password: String = "",
    val pofilePicture: String = "",
    val roles: String = "Fan",
    val username: String = "username11"
)