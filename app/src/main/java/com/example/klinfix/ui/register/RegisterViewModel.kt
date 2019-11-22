package com.example.klinfix.ui.register

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.klinfix.data.model.User
import com.example.klinfix.data.source.Repository
import com.example.klinfix.data.source.remote.reponse.RegisterResponse
import com.google.gson.JsonObject
import okhttp3.Credentials
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel(private val repository: Repository): ViewModel() {

    var name:String? = "rahmatsyah1"
    var username:String? = "rahmatsyahrahmat1"
    var password:String? = "Oioioioi1!"
    var confirmPassword:String? = "Oioioioi1!"
    var email:String? = "rahmatsyah1@gmail.com"

    var registerListener:RegisterListener? = null

    fun toLogin(){
        registerListener?.toLogin()
    }
    fun register(){
        if (registerListener?.validate()!!){
            registerListener?.onRegister()
            repository.register(name!!,username!!,password!!,email!!).enqueue(object :Callback<JsonObject>{
                override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                    registerListener?.onFailure(response.body().toString())
                }

            })
        }
    }

}