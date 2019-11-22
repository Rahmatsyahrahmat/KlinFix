package com.example.klinfix.data.source.local

import com.example.klinfix.data.source.local.room.Dao

class LocalRepository private constructor(private val databaseDao: Dao){

    companion object{
        private var INSTANCE:LocalRepository? = null

        fun getInstance(databaseDao: Dao):LocalRepository?{
            if (INSTANCE==null){
                INSTANCE = LocalRepository(databaseDao)
            }
            return INSTANCE
        }
    }
}