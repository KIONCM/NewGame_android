package com.example.game.pojo.models;

import android.content.Intent;

class Fan(firstName: String, lastName: String?, password: String?, email: String?,
          userName: String?
): User(firstName, lastName,
    password,
    email, userName
) {
    init {
        roles = userRole
    }


    override fun getUserType(): Class<*> {
        TODO("Not yet implemented")
    }

    override fun getUserRole(): String {
        return "Fan"
    }


}
