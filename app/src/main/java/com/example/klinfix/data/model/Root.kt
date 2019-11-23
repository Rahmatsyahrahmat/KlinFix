package com.example.klinfix.data.model

data class Root(
    var id:String,
    var job:String,
    var category: List<Category>
){
    fun getSubCategory(id:String):Category?{
        var res:Category? = null
        this.category.forEach {
            if (it.id==id) res = it
        }
        return res
    }
}