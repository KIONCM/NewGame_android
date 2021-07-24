package com.example.game.ui.register

import android.os.Bundle
import android.widget.Toast
import com.example.game.R
import com.example.game.databinding.ActivityRegisterBinding
import com.example.game.ui.base.BaseActivity

class RegisterActivity : BaseActivity<RegisterViewModel,ActivityRegisterBinding>(),Navigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel?.navigator = this
        binding?.vm = viewModel

    }

    override fun initializeViewModel()= RegisterViewModel()

    override fun inflateLayout() = R.layout.activity_register

    override fun login() {
        Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show()
    }

}