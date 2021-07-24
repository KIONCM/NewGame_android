package com.example.game.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel<N> : ViewModel() {
    var navigator :N?=null
    val message= MutableLiveData<String>()
    val loader = MutableLiveData<Boolean>()

}