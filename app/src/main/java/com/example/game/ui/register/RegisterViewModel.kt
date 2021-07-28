package com.example.game.ui.register

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.game.R
import com.example.game.api.Response
import com.example.game.api.RetrofitClient
import com.example.game.pojo.models.*
import com.example.game.ui.base.BaseViewModel
import io.reactivex.*
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import java.util.*

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
        if (true){
            //val user = getUser(userType.value!!,User(firstName.value,lastName.value,password.value,email.value,userName.value))
            Log.d(TAG, "register:firstName ${firstName.value} ")
            Log.d(TAG, "register:last ${lastName.value} ")
            Log.d(TAG, "register:user ${userName.value} ")
            Log.d(TAG, "register:type ${userType.value} ")
            Log.d(TAG, "register:password ${password.value} ")
            Log.d(TAG, "register:email ${email.value} ")

        /*    Log.d(TAG, "user :firstName ${user.firstName} ")
            Log.d(TAG, "user :last ${user.lastName} ")
            Log.d(TAG, "user :email ${user.email} ")
            Log.d(TAG, "user :password ${user.password} ")
            Log.d(TAG, "user :role  ${user.roles} ")
            Log.d(TAG, "user :user ${user.username} ")
*/
            val map = hashMapOf<String,String>()
            map["username"] = "userNameTest500"
            map["firstName"] = "firstNameTest"
            map["lastName"] = "lastNameTest"
            map["email"] = "email1234@test.com"
            map["password"] = "1234567890@Aa"
            map["pofilePicture"] = "null"
            map["roles"] = "Gamer"
            /*RetrofitClient.getApis().register(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(Schedulers.io())
                .subscribe(object :Observer<Response> {
                    override fun onSubscribe(d: Disposable) {
                        Log.d(TAG, "onSubscribe: ${d.isDisposed}")
                    }

                    override fun onNext(t: Response) {
                        Log.d(TAG, "onNext: ${t.message}")
                        Log.d(TAG, "onNext: ${t.statues_code}")
                    }

                    override fun onError(e: Throwable) {
                        Log.d(TAG, "onError: ${e.cause}")
                        Log.d(TAG, "onError: ${e.localizedMessage}")
                        Log.d(TAG, "onError: ${e.message}")
                    }

                    override fun onComplete() {
                        Log.d(TAG, "onComplete: ")
                    }

                }
                )*/
              /*  {
                    override fun onSubscribe(d: Disposable) {
                        Log.d(TAG, "onSubscribe: ${d.isDisposed}")
                    }

                    override fun onSuccess(t: Response) {
                        Log.d(TAG, "onSuccess: ${t.statues_code}")
                        Log.d(TAG, "onSuccess: ${t.message}")
                        navigator?.success()
                        loader.value = false

                    }

                    override fun onError(e: Throwable) {
                        Log.d(TAG, "onError: ${e.message}")
                        Log.d(TAG, "onError: ${e.localizedMessage}")
                        Log.d(TAG, "onError: ${e.cause}")
                        navigator?.failed(e.localizedMessage?:"error")
                        loader.value = false


                    }

                }*/

            RetrofitClient.getApis().register2(map).enqueue(object : Callback<Response> {
                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {
                    if (response.isSuccessful){
                        navigator?.success()
                        Log.d(TAG, "onResponse: ${response.body()?.statues_code}")
                        Log.d(TAG, "onResponse: ${response.body()?.message}")
                        Log.d(TAG, "onResponse: ${response.message()}")

                    }
                    else if (!response.isSuccessful){
                        navigator?.failed(response.message())
                        Log.d(TAG, "onResponse: failed ${response.body()?.statues_code}")
                        Log.d(TAG, "onResponse:failed ${response.body()?.message}")
                        Log.d(TAG, "onResponse: failed${response.message()}")

                    }
                    loader.value = false
                }

                override fun onFailure(call: Call<Response>, t: Throwable) {
                    navigator?.failed(t.localizedMessage)

                    Log.d(TAG, "onResponse: failure ${t.message}")
                    Log.d(TAG, "onResponse: failure ${t.localizedMessage}")
                    loader.value = false
                }
            })

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
