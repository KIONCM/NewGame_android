package com.example.game.ui.register

import androidx.lifecycle.MutableLiveData
import com.example.game.api.Response
import com.example.game.api.RetrofitClient
import com.example.game.pojo.models.RegisterModel
import com.example.game.ui.base.BaseViewModel
import io.reactivex.Scheduler
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RegisterViewModel : BaseViewModel<Navigator>() {
    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val userName = MutableLiveData<String>()

    fun register() {
        loader.value = true
        val user = RegisterModel("ahmed1@gmail.com","ahmed1","mostafa1","1234567890@Aa")
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
        //navigator?.login()
    }
    private fun isDataValid():Boolean{
        return !email.value.isNullOrBlank()
    }
}
