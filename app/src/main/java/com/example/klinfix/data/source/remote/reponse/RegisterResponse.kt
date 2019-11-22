package com.example.klinfix.data.source.remote.reponse

import com.example.klinfix.data.model.User

data class RegisterResponse (
    var data:List<User>?,
    var message:String?,
    var error:ErrorResponse?
)