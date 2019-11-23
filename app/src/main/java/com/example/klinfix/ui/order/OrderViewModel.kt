package com.example.klinfix.ui.order

import android.content.Context
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.example.klinfix.data.source.Repository
import com.google.gson.JsonObject
import okhttp3.Credentials
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrderViewModel(val repository: Repository):ViewModel() {

    var subCategory:String? = null
    var date:String? = null
    var location:String? = null
    var memo:String? = null

    var orderListener:OrderListener? = null

    fun order(string: String){
        repository?.order(string,subCategory!!,date!!,memo!!,location!!,"-6.2968282","106.803776")
            .enqueue(object :Callback<JsonObject>{
                override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                    orderListener?.onFailure()
                }

                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                    Log.i("oioioioi",response.errorBody()?.string().toString())
                    if (response.body()!=null)orderListener?.onSuccess()
                }

            })
    }


}