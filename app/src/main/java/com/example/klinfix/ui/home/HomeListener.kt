package com.example.klinfix.ui.home

import com.example.klinfix.data.model.SubCategory

interface HomeListener {
    fun toDetail(category:String,subCategory: List<SubCategory>)
    fun onFailure()
}