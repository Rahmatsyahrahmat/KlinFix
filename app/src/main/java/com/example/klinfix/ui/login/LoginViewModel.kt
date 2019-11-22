package com.example.klinfix.ui.login

import androidx.lifecycle.ViewModel
import com.example.klinfix.data.source.Repository
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(val repository: Repository):ViewModel() {

    var username:String? = "fachril21"
    var password:String?= "Abcde121*"

    var loginListener:LoginListener? = null

    fun toRegister(){
        loginListener?.toRegister()
    }
    fun login(){
        repository.login(username!!,password!!).enqueue(object : Callback<JsonObject>{
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                loginListener?.onFailure(t.message.toString())
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                loginListener?.onFailure(response.body().toString())
            }

        })
    }

}