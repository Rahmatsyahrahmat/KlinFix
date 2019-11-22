package com.example.klinfix.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.klinfix.data.model.User

@Database(entities = [User::class],version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    abstract fun databaseDao(): Dao


    companion object{
        private var INSTANCE:AppDatabase? = null
        private val sLock = Object()

        fun getInstance(context: Context):AppDatabase?{
            synchronized(sLock){
                if (INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,"AppDatabase.db").build()
                }
            }
            return INSTANCE
        }
    }

}