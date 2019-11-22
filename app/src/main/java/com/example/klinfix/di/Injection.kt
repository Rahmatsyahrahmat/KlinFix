package com.example.klinfix.di

import android.app.Application
import com.example.klinfix.data.source.Repository
import com.example.klinfix.data.source.local.LocalRepository
import com.example.klinfix.data.source.local.room.AppDatabase
import com.example.klinfix.data.source.remote.RemoteRepository
import com.example.klinfix.utils.AppExecutor
import com.example.klinfix.utils.JsonHelper

object Injection{

    fun provideRepository(application: Application): Repository?{
        val appDatabase = AppDatabase.getInstance(application)

        val localRepository = appDatabase?.databaseDao()?.let { LocalRepository.getInstance(it) }
        val remoteRepository = RemoteRepository.getInstance(JsonHelper)
        val appExecutor = AppExecutor()
        return localRepository?.let { local ->
            remoteRepository?.let { remote ->
                Repository.getInstance(local,remote,appExecutor) }
        }
    }

}