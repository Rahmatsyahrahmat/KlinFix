package com.example.klinfix.data.source.remote.reponse

import com.example.klinfix.data.model.User

data class LoginResponse (
    var code:Int,
    var data:User
)