package com.example.klinfix.ui.order

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.klinfix.R
import com.example.klinfix.data.model.SubCategory
import com.example.klinfix.databinding.ActivityOrderBinding
import com.example.klinfix.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity(),OrderListener {

    lateinit var array:Array<SubCategory>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding:ActivityOrderBinding = DataBindingUtil.setContentView(this,R.layout.activity_order)
        val viewModel = ViewModelProviders.of(this,ViewModelFactory.getInstance(application)).get(OrderViewModel::class.java)
        binding.viewModel = viewModel

        tvCategory.text = intent.extras?.getString("category")

        array = intent.extras!!.getParcelableArray("subcategory")!!.filterIsInstance<SubCategory>().toTypedArray()

        val category = mutableListOf<String>()
        array.forEach { category.add(it.title) }

        viewModel.subCategory = array[0].id

        viewModel.orderListener = this

        spSubcategory.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_item,
            category
        )

        spSubcategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                viewModel.subCategory = array[0].id
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                viewModel.subCategory = array[position].id
            }

        }

        btnOrder.setOnClickListener {
            viewModel.order(getSharedPreferences("User",Context.MODE_PRIVATE).getString("credential","").toString())
        }

    }



    override fun onSuccess() {
        Toast.makeText(this,"Order Added",Toast.LENGTH_LONG).show()
        finish()
    }

    override fun onFailure() {
        Toast.makeText(this,"Failure to add your order",Toast.LENGTH_LONG).show()
    }

}
