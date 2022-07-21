package com.example.juegodecolores

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_final.*

class ActivityFinal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        var constraintLayout = findViewById<ConstraintLayout>(R.id.finalActivity_layout)

        var animationDrawable : AnimationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()

        var puntajeFinal = intent.getIntExtra("puntaje",0)

        txtPuntuacionFinal.text = puntajeFinal.toString()

    }
}