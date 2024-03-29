package com.example.klinfix.data.source

import com.example.klinfix.data.model.User
import com.example.klinfix.data.source.remote.reponse.CategoryResponse
import com.example.klinfix.data.source.remote.reponse.LoginResponse
import com.example.klinfix.data.source.remote.reponse.RegisterResponse
import com.google.gson.JsonObject
import retrofit2.Call

interface DataSource {

    fun register(name:String,username:String,password:String,email:String):Call<RegisterResponse>

    fun login(username:String,password: String):Call<LoginResponse>

    fun edit(credential:String, address:String,phoneNumber:String):Call<RegisterResponse>

    fun getCategory():Call<CategoryResponse>

    fun order(credential: String,subcategory:String,date:String,memo:String,address: String,lat:String,long:String):Call<JsonObject>

}