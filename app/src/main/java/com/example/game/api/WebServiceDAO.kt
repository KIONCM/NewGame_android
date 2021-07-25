package com.example.game.api

import com.example.game.pojo.models.RegisterModel
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface WebServiceDAO {


    @POST("/api/Account")
    fun register(@Body model: RegisterModel): Single<Response>
}