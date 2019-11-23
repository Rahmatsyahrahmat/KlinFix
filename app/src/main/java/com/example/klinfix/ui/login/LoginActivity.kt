package com.example.klinfix.ui.login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.klinfix.R
import com.example.klinfix.databinding.ActivityLoginBinding
import com.example.klinfix.ui.main.MainActivity
import com.example.klinfix.ui.register.RegisterActivity
import com.example.klinfix.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() , LoginListener{

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        viewModel = obtainViewModel()
        binding.viewModel = viewModel

        viewModel.loginListener = this
    }

    private fun obtainViewModel() =
        ViewModelProviders.of(this,ViewModelFactory.getInstance(application)).get(LoginViewModel::class.java)

    override fun validate(): Boolean {
        if (etUsername.text.isEmpty()){
            etUsername.error = "Email empty"
            return false
        }
        if (etPassword.text.isEmpty()){
            etPassword.error = "Password Empty"
            return false
        }
        return true
    }

    override fun toRegister() {
        startActivity(Intent(this,RegisterActivity::class.java))
    }

    override fun onLogin() {
        progressLogin.visibility = View.VISIBLE
        btnLogin.text = ""
    }

    override fun onSuccess() {
        Toast.makeText(this,"Success Login",Toast.LENGTH_LONG).show()
        startActivity(Intent(this,MainActivity::class.java))
    }

    @SuppressLint("SetTextI18n")
    override fun onFailure(message: String) {
        progressLogin.visibility = View.GONE
        btnLogin.text = "Login"
    }

}
