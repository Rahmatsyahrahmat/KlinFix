package com.example.klinfix.ui.login

interface LoginListener {
    fun validate():Boolean
    fun toRegister()
    fun onLogin()
    fun onSuccess(credential: String)
    fun onFailure(message:String)
}