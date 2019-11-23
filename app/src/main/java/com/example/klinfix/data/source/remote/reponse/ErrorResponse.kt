package com.example.klinfix.data.source.remote.reponse

data class ErrorResponse (
    var name:List<String>?,
    var username:List<String>?,
    var password:List<String>?,
    var email:List<String>?
){
    fun getError():String{
        val error = mutableListOf<String>()
        name?.let { error.addAll(it) }
        username?.let { error.addAll(it) }
        password?.let { error.addAll(it) }
        email?.let { error.addAll(it) }

        return  error[0]
    }
}