package com.example.game.ui.register

import android.os.Bundle
import android.os.Message
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.widget.doOnTextChanged
import com.example.game.R
import com.example.game.databinding.ActivityRegisterBinding
import com.example.game.ui.base.BaseActivity

class RegisterActivity : BaseActivity<RegisterViewModel,ActivityRegisterBinding>(),Navigator {
    private val TAG = "RegisterActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel?.navigator = this
        binding?.vm = viewModel
        val items = listOf("Material", "Design", "Components", "Android")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        (binding?.userTypeTil?.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        binding?.emailTil?.editText?.doOnTextChanged { text, start, before, count ->
            if(!text!!.contains("@")){
                binding?.userNameTie?.setText(text)
            }
        }

    }

    override fun initializeViewModel()= RegisterViewModel()

    override fun inflateLayout() = R.layout.activity_register

    override fun login() {
        Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show()
    }

    override fun success() {
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
    }

    override fun failed(message: String) {
        Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
        showMessage(message)
    }

}