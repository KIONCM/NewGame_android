package com.example.game.ui.base

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity<VM: BaseViewModel<*>,DB: ViewDataBinding> : AppCompatActivity() {
    var viewModel :VM?=null
    var binding :DB?=null
    private var loader: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(initializeViewModel()::class.java)
        binding  = DataBindingUtil.setContentView(this,inflateLayout())

    }

    abstract fun initializeViewModel():VM
    abstract fun inflateLayout():Int

    fun showMessage(message: String) {
        AlertDialog.Builder(this).setMessage(message).setCancelable(false)
            .setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            }).show()
    }

    fun showDialog(
        title: String,
        message: String,
        posBtnText: String,
        posBtnClickListener: DialogInterface.OnClickListener,
        negBtnText:String?=null
    ) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton(posBtnText, posBtnClickListener)
            .setNegativeButton(negBtnText) { dialog, _ ->
                dialog.dismiss()
            }

            .show()
    }

    fun showLoader() {
        loader = ProgressDialog(this)
        loader?.apply { ->
            setMessage("Loading...")
            setCancelable(false)
            show()
        }

    }

    fun hideLoader() {
        if (loader != null && loader?.isShowing!!) {
            loader?.dismiss()
        }
    }


    private fun observers() {
        viewModel?.message?.observe(this, Observer {
            showMessage(it)
        })
        viewModel?.loader?.observe(this, Observer {
            when (it) {
                true -> showLoader()
                false -> hideLoader()
            }
        })

    }
}