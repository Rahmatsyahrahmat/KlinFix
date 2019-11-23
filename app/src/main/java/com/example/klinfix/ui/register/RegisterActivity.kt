package com.example.klinfix.ui.register

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

import com.example.klinfix.R
import com.example.klinfix.databinding.ActivityRegisterBinding
import com.example.klinfix.ui.login.LoginActivity
import com.example.klinfix.ui.main.MainActivity
import com.example.klinfix.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(),RegisterListener {

    lateinit var viewModel:RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityRegisterBinding = DataBindingUtil.setContentView(this,R.layout.activity_register)
        viewModel = obtainViewModel()
        binding.viewModel = viewModel

        viewModel.registerListener = this

    }

    private fun obtainViewModel():RegisterViewModel = ViewModelProviders.of(this,ViewModelFactory.getInstance(application)).get(RegisterViewModel::class.java)


    override fun validate(): Boolean {
        if (etName.text.isEmpty()){
            etName.error = "Name empty"
            return false
        }
        if (etUsername.text.isEmpty()){
            etUsername.error = "Email Empty"
            return false
        }
        if (etPassword.text.isEmpty()){
            etPassword.error = "Password Empty"
            return false
        }
        if (etConfirmPassword.text.isEmpty()){
            etConfirmPassword.error = "Confirm Password Empty"
            return false
        }
        if (etPassword.text.length<8){
            etPassword.error = "Minimum 8 character"
        }
        if (etPassword.text.toString() != etConfirmPassword.text.toString()) {
            etPassword.error = "Different Password"
            etConfirmPassword.error = "Different Password"
            return false
        }

        if (etEmail.text.isEmpty()){
            etEmail.error = "Email Empty"
            return false
        }
        if (etAddress.text.isEmpty()){
            etAddress.error = "Address Empty"
            return false
        }
        if (etPhoneNumber.text.isEmpty()){
            etPhoneNumber.error = "Phone Empty"
            return false
        }
        return true
    }

    override fun toLogin() {
        startActivity(Intent(this,LoginActivity::class.java))
    }

    override fun onRegister() {
        progressRegister.visibility = View.VISIBLE
        btnRegister.text = ""
    }

    override fun onSuccess() {
        Toast.makeText(this,"Register Successful, check your email to verify your registration",Toast.LENGTH_LONG).show()
        startActivity(Intent(this,LoginActivity::class.java))
    }

    @SuppressLint("SetTextI18n")
    override fun onFailure(message:String) {
        progressRegister.visibility = View.GONE
        btnRegister.text = "Register"
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}
