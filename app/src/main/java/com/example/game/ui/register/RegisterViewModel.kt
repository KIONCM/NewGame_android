package com.example.game.ui.register

import com.example.game.ui.base.BaseViewModel

class RegisterViewModel: BaseViewModel<Navigator>() {

    fun login() {
        navigator?.login()
    }
}