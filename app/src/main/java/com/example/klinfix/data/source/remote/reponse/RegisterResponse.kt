package com.example.klinfix.data.source.remote.reponse

import com.example.klinfix.data.model.User

data class RegisterResponse (
    var code:Int,
    var data:User?,
    var message:String?
)