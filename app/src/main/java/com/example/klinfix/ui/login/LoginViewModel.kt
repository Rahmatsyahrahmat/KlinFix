package com.example.klinfix.ui.login

import androidx.lifecycle.ViewModel
import com.example.klinfix.data.source.Repository
import com.example.klinfix.data.source.remote.reponse.LoginResponse
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(private val repository: Repository):ViewModel() {

    var username:String? = null
    var password:String?= null

    var loginListener:LoginListener? = null

    fun toRegister(){
        loginListener?.toRegister()
    }
    fun login(){
        if (loginListener?.validate()!!){
            loginListener?.onLogin()
            repository.login(username!!,password!!).enqueue(object : Callback<LoginResponse>{
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    loginListener?.onFailure(t.message.toString())
                }

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.body()!=null){
                        loginListener?.onSuccess()
                    }
                    else{
                        val error = JSONObject(response.errorBody()?.string().toString()).getString("error")
                        loginListener?.onFailure(error)
                    }
                }

            })
        }

    }

}