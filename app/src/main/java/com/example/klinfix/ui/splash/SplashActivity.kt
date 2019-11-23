package com.example.klinfix.ui.splash

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.klinfix.R
import com.example.klinfix.ui.login.LoginActivity
import com.example.klinfix.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val runnable = Runnable {
            if (!isFinishing) {
                if (isUserExist()){
                    startActivity(Intent(this,MainActivity::class.java))
                }
                else{
                    startActivity(Intent(this,LoginActivity::class.java))
                }
            }
        }

        val delayHandler  = Handler()
        val SPLASH_DELAY: Long = 2000

        delayHandler.postDelayed(runnable, SPLASH_DELAY)


    }

    fun isUserExist():Boolean = getSharedPreferences("User",Context.MODE_PRIVATE).getString("credential","") != ""
}
