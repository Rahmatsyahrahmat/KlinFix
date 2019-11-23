package com.example.klinfix.utils

import com.example.klinfix.data.model.User
import com.example.klinfix.data.source.remote.reponse.LoginResponse
import com.example.klinfix.data.source.remote.reponse.RegisterResponse
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface IJsonHelper {

    @Headers("Content-Type: application/json")
    @POST("register/user")
    fun register( @Body user: User):Call<RegisterResponse>

    @POST("auth/user")
    fun login(@Header("Authorization") authToken: String,@Body user: User):Call<LoginResponse>

}