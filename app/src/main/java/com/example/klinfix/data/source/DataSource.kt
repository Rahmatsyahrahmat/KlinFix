package com.example.klinfix.data.source

import com.example.klinfix.data.model.User
import com.example.klinfix.data.source.remote.reponse.RegisterResponse
import com.google.gson.JsonObject
import retrofit2.Call

interface DataSource {

    fun register(name:String,username:String,password:String,email:String):Call<JsonObject>

    fun login(username:String,password: String):Call<JsonObject>
}