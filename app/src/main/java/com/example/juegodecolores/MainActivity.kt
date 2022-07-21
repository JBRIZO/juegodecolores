package com.example.juegodecolores

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_juego.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var constraintLayout = findViewById<ConstraintLayout>(R.id.main_layout)

        var animationDrawable : AnimationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()

        btnIniciar.setOnClickListener { iniciarJuego() }

    }

    private fun iniciarJuego(){
        val intent = Intent(this,JuegoActivity::class.java)
        startActivity(intent)
    }
}