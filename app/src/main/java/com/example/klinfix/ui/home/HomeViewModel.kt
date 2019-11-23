package com.example.klinfix.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.klinfix.data.model.SubCategory
import com.example.klinfix.data.source.Repository
import com.example.klinfix.data.source.remote.reponse.CategoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(val repository: Repository) : ViewModel() {

    var homeListener:HomeListener? = null

    fun getSubCategory(root:Int,category:Int){
        repository.getCategory().enqueue(object : Callback<CategoryResponse>{
            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                homeListener?.onFailure()
            }

            override fun onResponse(
                call: Call<CategoryResponse>,
                response: Response<CategoryResponse>
            ) {
//                homeListener?.onFailure(response.body().toString())
                response.body()?.data?.get(root)?.getSubCategory(category.toString())?.subcategory?.let {
                    toDetail(
                        response.body()?.data?.get(root)?.getSubCategory(category.toString())?.title!!,it
                    )
                }
            }

        })
    }
    fun toDetail(category:String,subCategories: List<SubCategory>){
        homeListener?.toDetail(category,subCategories)
    }

}