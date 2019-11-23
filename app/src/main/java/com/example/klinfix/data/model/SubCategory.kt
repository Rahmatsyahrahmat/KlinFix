package com.example.klinfix.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SubCategory (
    var id:String,
    var title:String
):Parcelable