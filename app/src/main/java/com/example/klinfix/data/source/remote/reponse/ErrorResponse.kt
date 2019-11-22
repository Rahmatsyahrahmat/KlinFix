package com.example.klinfix.data.source.remote.reponse

data class ErrorResponse (
    var message:String,
    var password:List<String>,
    var username:List<String>,
    var name:List<String>,
    var email:List<String>
)