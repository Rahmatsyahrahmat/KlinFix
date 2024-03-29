package com.example.klinfix.data.source

import com.example.klinfix.data.model.User
import com.example.klinfix.data.source.local.LocalRepository
import com.example.klinfix.data.source.remote.RemoteRepository
import com.example.klinfix.data.source.remote.reponse.CategoryResponse
import com.example.klinfix.data.source.remote.reponse.LoginResponse
import com.example.klinfix.data.source.remote.reponse.RegisterResponse
import com.example.klinfix.utils.AppExecutor
import com.google.gson.JsonObject
import retrofit2.Call

class Repository private constructor(
    private val localRepository: LocalRepository,
    private val remoteRepository: RemoteRepository,
    private val appExecutor: AppExecutor
) :
    DataSource{

    companion object{
        @Volatile
        private var INSTANCE:Repository? = null

        fun getInstance(localRepository: LocalRepository, remoteRepository: RemoteRepository, appExecutor: AppExecutor):Repository?{
            if (INSTANCE==null){
                synchronized(Repository::class.java){
                    if (INSTANCE==null){
                        INSTANCE = Repository(localRepository,remoteRepository,appExecutor)
                    }
                }
            }
            return INSTANCE
        }

    }

    override fun register(name: String, username: String, password: String, email: String) = remoteRepository.register(
        User(name,username,password,email,"","")
    )

    override fun login(username: String, password: String): Call<LoginResponse> =
        remoteRepository.login(User("",username,password,"","",""))

    override fun edit(credential:String, address: String, phoneNumber: String): Call<RegisterResponse> = remoteRepository.edit(credential,address,phoneNumber)

    override fun getCategory(): Call<CategoryResponse> = remoteRepository.getCategory()

    override fun order(
        credential: String,
        subcategory: String,
        date: String,
        memo: String,
        address: String,
        lat: String,
        long: String
    ) :Call<JsonObject> = remoteRepository.order(credential,subcategory,date,memo,address,lat,long)

}