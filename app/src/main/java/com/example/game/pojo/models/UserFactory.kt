package com.example.game.pojo.models

class UserFactory {
    public fun create(role:String,user: User):User{
        return when(role){
            "Fan"->{
                Fan(firstName = user.firstName,lastName = user.lastName,password = user.password,email = user.email,userName = user.username)
            }
            "Gamer"->{
                Gamer(firstName = user.firstName,lastName = user.lastName,password = user.password,email = user.email, userName = user.username).apply {
                    roles = "Gamer"
                }
            }
            else ->{
                Player(firstName = user.firstName,lastName = user.lastName,password = user.password,email = user.email,userName = user.username).apply {
                    roles = "Player"
                }

            }
        }
    }
}