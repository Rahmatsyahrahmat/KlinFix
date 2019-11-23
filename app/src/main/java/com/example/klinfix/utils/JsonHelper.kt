package com.example.klinfix.utils

import com.example.klinfix.data.model.User
import com.example.klinfix.data.source.remote.reponse.LoginResponse
import com.example.klinfix.data.source.remote.reponse.RegisterResponse
import com.google.gson.JsonObject
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.internal.Util.UTF_8
import okhttp3.logging.HttpLoggingInterceptor
import okio.Utf8
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.util.*
import java.util.concurrent.TimeUnit

object JsonHelper {

    private val BASE_URL:String = "https://api.klinnfix.com/V1/"

    private var service:IJsonHelper
    private var mClient: OkHttpClient? = null

    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(IJsonHelper::class.java)
    }

    fun register(user: User):Call<RegisterResponse> = service.register(user)

    fun login(user: User):Call<LoginResponse> = service.login(Credentials.basic(user.username,user.password),user)

}