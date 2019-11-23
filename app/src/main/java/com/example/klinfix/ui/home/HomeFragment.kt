package com.example.klinfix.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.klinfix.R
import com.example.klinfix.data.model.SubCategory
import com.example.klinfix.ui.order.OrderActivity
import com.example.klinfix.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() , View.OnClickListener,HomeListener{

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this,
                activity?.application?.let { ViewModelFactory.getInstance(it) }).get(HomeViewModel::class.java)
        viewModel.homeListener = this
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cvGeneralClean.setOnClickListener(this)
        cvDeepClean.setOnClickListener(this)
        cvBed.setOnClickListener(this)
        cvBabyBed.setOnClickListener(this)
        cvSofa.setOnClickListener(this)
        cvRoof.setOnClickListener(this)
        cvBrick.setOnClickListener(this)
        cvFloor.setOnClickListener(this)
        cvElectric.setOnClickListener(this)
        cvWater.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.cvGeneralClean -> viewModel.getSubCategory(0,1)
            R.id.cvDeepClean -> viewModel.getSubCategory(0,2)
            R.id.cvBed -> viewModel.getSubCategory(0,3)
            R.id.cvBabyBed -> viewModel.getSubCategory(0,4)
            R.id.cvSofa -> viewModel.getSubCategory(0,5)
            R.id.cvRoof -> viewModel.getSubCategory(1,6)
            R.id.cvBrick -> viewModel.getSubCategory(1,7)
            R.id.cvFloor -> viewModel.getSubCategory(1,8)
            R.id.cvElectric -> viewModel.getSubCategory(1,10)
            R.id.cvWater -> viewModel.getSubCategory(1,11)
        }
    }
    override fun toDetail(category:String,subCategory: List<SubCategory>) {
        val intent = Intent(context,OrderActivity::class.java)
        intent.putExtra("category",category)
        intent.putExtra("subcategory",subCategory.toTypedArray())
        startActivity(intent)
    }

    override fun onFailure() {
        Toast.makeText(context,"Failure to get Data",Toast.LENGTH_LONG).show()
    }
}
