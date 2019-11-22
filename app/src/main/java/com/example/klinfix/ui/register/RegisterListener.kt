package com.example.klinfix.ui.register

interface RegisterListener {
    fun validate():Boolean
    fun toLogin()
    fun onRegister()
    fun onSuccess()
    fun onFailure(message:String)
}