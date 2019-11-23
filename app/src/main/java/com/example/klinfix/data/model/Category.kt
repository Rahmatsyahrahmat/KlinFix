package com.example.klinfix.data.model

data class Category (
    var id:String,
    var title:String,
    var subcategory: List<SubCategory>
)