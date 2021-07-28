package com.example.game.api

import com.example.game.pojo.models.User
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.*

interface WebServiceDAO {

//@Headers("accept: */*","Content-Type: application/json")
    @POST("/api/Account")
    fun register(@Body model: HashMap<String,String>): Observable<Response>

    @POST("/api/Account")
    fun register2(@Body model: HashMap<String,String>): Call<Response>
}