package com.example.klinfix.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.klinfix.data.source.Repository
import com.example.klinfix.di.Injection
import com.example.klinfix.ui.home.HomeViewModel
import com.example.klinfix.ui.login.LoginViewModel
import com.example.klinfix.ui.order.OrderViewModel
import com.example.klinfix.ui.register.RegisterViewModel

class ViewModelFactory private constructor(private val repository: Repository?):
    ViewModelProvider.NewInstanceFactory() {

    companion object{
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application):ViewModelFactory?{
            if (INSTANCE==null){
                synchronized(ViewModelFactory::class.java){
                    if (INSTANCE==null){
                        INSTANCE = ViewModelFactory(Injection.provideRepository(application))
                    }
                }
            }
            return INSTANCE
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> repository?.let { RegisterViewModel(it) } as T
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> repository?.let { LoginViewModel(it) } as T
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> repository?.let { HomeViewModel(it) } as T
            modelClass.isAssignableFrom(OrderViewModel::class.java) -> repository?.let { OrderViewModel(it) } as T
//            modelClass.isAssignableFrom(SplashViewModel::class.java) -> repository?.let { SplashViewModel(it) } as T
//            modelClass.isAssignableFrom(ProfileViewModel::class.java) -> repository?.let { ProfileViewModel(it) } as T
//            modelClass.isAssignableFrom(EditProfileViewModel::class.java) -> repository?.let { EditProfileViewModel(it) } as T
            else -> throw IllegalArgumentException("Unknown ViewModel Class: "+modelClass.name)
        }
    }

}