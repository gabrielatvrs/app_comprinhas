package com.ctt.listadecompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_tela)
        iniciarApp()
    }

    fun iniciarApp() {
        Handler(Looper.getMainLooper()).postDelayed({
            val telaInicio = Intent(this, MainActivity::class.java)
            startActivity(telaInicio)
            finish()
        }, 3000)
    }
}