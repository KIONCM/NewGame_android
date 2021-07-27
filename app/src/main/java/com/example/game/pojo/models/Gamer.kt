package com.example.game.pojo.models;

class Gamer(firstName: String, lastName: String?, password: String?, email: String?,
            userName: String?
) : User(firstName, lastName,
    password,
    email, userName
) {

    fun Gamer(
        firstName: String,
        lastName: String?,
        password: String?,
        email: String?,
        userName: String?
    ) {
        this.firstName = firstName
        this.lastName = lastName
        this.password = password
        this.email = email
        username = userName
        if (firstName === "ahmed") {
            roles = "Gamer"
        }
    }
    init {
        roles = userRole
    }


    override fun getUserType(): Class<*>? {
        return null
    }

    override fun getUserRole(): String {
        return "Gamer"
    }


}
