package com.example.game.ui.register

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.game.R
import com.example.game.api.Response
import com.example.game.api.RetrofitClient
import com.example.game.pojo.models.*
import com.example.game.ui.base.BaseViewModel
import io.reactivex.Scheduler
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RegisterViewModel : BaseViewModel<Navigator>() {
    private val TAG = "RegisterViewModel"
    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val userName = MutableLiveData<String>()
    val userType =MutableLiveData<String>()

    val firstNameError = MutableLiveData<Boolean>()
    val lastNameError = MutableLiveData<Boolean>()
    val emailError = MutableLiveData<Boolean>()
    val passwordError = MutableLiveData<Boolean>()
    val typeError = MutableLiveData<Boolean>()

    fun register() {
        loader.value = true
        if (isDataValid()){
            val user = getUser(userType.value!!,User(firstName.value,lastName.value,password.value,email.value,userName.value))
            Log.d(TAG, "register: ")
            RetrofitClient.getApis().register(user).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(Schedulers.io())
                .subscribe(object : SingleObserver<Response> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onSuccess(t: Response) {
                        navigator?.success()
                        loader.value = false

                    }

                    override fun onError(e: Throwable) {
                        navigator?.failed(e.localizedMessage?:"error")
                        loader.value = false


                    }

                } )
        }else {
            loader.value = false
            message.value = "Incomplete Data"
        }
        //navigator?.login()
    }
    private fun isDataValid():Boolean{
        if (firstName.value.isNullOrBlank()) firstNameError.value = true
        if (lastName.value.isNullOrBlank()) lastNameError.value = true
        if (email.value.isNullOrBlank()) emailError.value = true
        if (password.value.isNullOrBlank()) passwordError.value = true
        if (userType.value.isNullOrBlank()) typeError.value = true && return false
        return true
    }

    private fun getUser(role:String,user: User):User{
      return UserFactory().create(role,user)
    }

}
