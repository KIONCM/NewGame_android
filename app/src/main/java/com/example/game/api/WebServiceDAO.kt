package com.example.game.api

import com.example.game.pojo.models.User
import io.reactivex.Single
import retrofit2.http.*

interface WebServiceDAO {


    @POST("/api/Account")
    @Headers("accept: */*","Content-Type: application/json")
    fun register(@Body model: User): Single<Response>
}