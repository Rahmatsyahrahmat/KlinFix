package com.example.klinfix.ui.login

interface LoginListener {
    fun validate():Boolean
    fun toRegister()
    fun onLogin()
    fun onSuccess()
    fun onFailure(message:String)
}