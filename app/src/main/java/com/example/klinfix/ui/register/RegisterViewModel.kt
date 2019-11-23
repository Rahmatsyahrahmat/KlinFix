package com.example.klinfix.ui.register

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.klinfix.data.model.User
import com.example.klinfix.data.source.Repository
import com.example.klinfix.data.source.remote.reponse.ErrorResponse
import com.example.klinfix.data.source.remote.reponse.RegisterResponse
import com.google.gson.Gson
import com.google.gson.JsonObject
import okhttp3.Credentials
import org.json.JSONArray
import org.json.JSONObject
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
            repository.register(name!!,username!!,password!!,email!!).enqueue(object :Callback<RegisterResponse>{
                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    registerListener?.onFailure(t.message.toString())
                }

                override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                    if (response.body() !=null){
                        registerListener?.onSuccess()
                    }else{

                        val root = JSONObject(response.errorBody()?.string().toString()).getJSONObject("error")
                        val errorResponse = Gson().fromJson(root.toString(),ErrorResponse::class.java)
                        registerListener?.onFailure(errorResponse.getError())

                    }
                }

            })
        }
    }

}
