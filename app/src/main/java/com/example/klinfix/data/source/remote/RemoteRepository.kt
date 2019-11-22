package com.example.klinfix.data.source.remote

import com.example.klinfix.data.model.User
import com.example.klinfix.utils.JsonHelper

class RemoteRepository private constructor(private val jsonHelper: JsonHelper){

    companion object{
        private var INSTANCE:RemoteRepository? = null

        fun getInstance(jsonHelper: JsonHelper):RemoteRepository?{
            if (INSTANCE==null){
                INSTANCE = RemoteRepository(jsonHelper)
            }
            return INSTANCE
        }
    }

    fun register(user: User) = jsonHelper.register(user)

    fun login(user: User) = jsonHelper.login(user)
}