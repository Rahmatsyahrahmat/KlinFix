package com.example.klinfix.data.model

import com.google.gson.annotations.SerializedName

data class Transaction (
    @SerializedName("subcategory")
    var subcategory:String,
    @SerializedName("date_service")
    var date_service:String,
    @SerializedName("memo")
    var memo:String,
    @SerializedName("address")
    var address: String,
    @SerializedName("latitude")
    var lat:String,
    @SerializedName("longitude")
    var long:String
)