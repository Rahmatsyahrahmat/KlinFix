package com.example.klinfix.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "User")
data class User (
    @SerializedName("name")
    @Expose
    var name:String,
    @PrimaryKey
    @SerializedName("username")
    @Expose
    var username:String,
    @SerializedName("password")
    @Expose
    var password:String,
    @SerializedName("email")
    @Expose
    var email:String,
    @SerializedName("address")
    @Expose
    var address:String,
    @SerializedName("phone")
    @Expose
    var phone:String

)