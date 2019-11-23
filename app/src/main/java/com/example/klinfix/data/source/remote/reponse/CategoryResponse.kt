package com.example.klinfix.data.source.remote.reponse

import com.example.klinfix.data.model.Root

data class CategoryResponse (
    var code:Int,
    var data:List<Root>
)