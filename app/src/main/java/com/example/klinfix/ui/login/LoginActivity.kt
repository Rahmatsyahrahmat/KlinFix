package com.example.klinfix.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.klinfix.R
import com.example.klinfix.databinding.ActivityLoginBinding
import com.example.klinfix.viewmodel.ViewModelFactory

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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toRegister() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLogin() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailure(message: String) {
        Log.i("oioioioi",message)
    }

}
