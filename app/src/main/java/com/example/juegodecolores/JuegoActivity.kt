package com.example.juegodecolores

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_juego.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*


class JuegoActivity : AppCompatActivity() {

    private val scope = MainScope()

    var colorGenerado : Int = 0
    var puntaje = 0
    var jugadaActual = 0
    private var cargando = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)

        puntaje = intent.getIntExtra("puntaje",0)
        jugadaActual = intent.getIntExtra("jugadaActual",0)
        Toast.makeText(this,puntaje.toString(),Toast.LENGTH_SHORT).show()


        when (jugadaActual) {
            0 -> {
                AlertDialog.Builder(this)
                    .setTitle("Instrucciones del juego")
                    .setMessage("A continuacion se le presentara un color en pantalla, tendra unos segundos para verlo, " +
                            "luego se le dara una serie de colores de los cuales debe seleccionar " +
                            "el color que se le mostro anteriormente.\nRespuesta acertada: +10 puntos ")
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                        colorGenerado = generarColorAleatorio()
                        layoutJuego.setBackgroundColor(colorGenerado)

                        val linearIndicator: ProgressBar = findViewById(R.id.progressBar)

                        scope.launch {
                            while (cargando){
                                progress(linearIndicator)
                            }
                            val intent = Intent(this@JuegoActivity,ActivityOpciones::class.java)
                            intent.putExtra("colorGenerado",colorGenerado)
                            intent.putExtra("puntaje",puntaje)
                            intent.putExtra("jugadaActual",jugadaActual)
                            startActivity(intent)
                            this@JuegoActivity.finish()
                        }
                    }
                    .show()
            }
            10 -> {
                val intent = Intent(this,ActivityFinal::class.java)
                intent.putExtra("puntaje",puntaje)
                intent.putExtra("jugadaActual",jugadaActual)
                startActivity(intent)
                this.finish()
            }
            else -> {
                AlertDialog.Builder(this)
                    .setTitle("¿Desea Continuar?")
                    .setPositiveButton("Si") { dialog, _ ->
                        dialog.dismiss()
                        colorGenerado = generarColorAleatorio()
                        layoutJuego.setBackgroundColor(colorGenerado)
                        val linearIndicator: ProgressBar = findViewById(R.id.progressBar)

                        scope.launch {
                            while (cargando){
                                progress(linearIndicator)
                            }
                            val intent = Intent(this@JuegoActivity,ActivityOpciones::class.java)
                            intent.putExtra("colorGenerado",colorGenerado)
                            intent.putExtra("puntaje",puntaje)
                            intent.putExtra("jugadaActual",jugadaActual)
                            startActivity(intent)
                            this@JuegoActivity.finish()
                        }

                    }
                    .setNegativeButton("No"){dialog, which ->
                        dialog.dismiss()
                        val intent = Intent(this,ActivityFinal::class.java)
                        intent.putExtra("puntaje",puntaje)
                        startActivity(intent)
                        this.finish()
                    }
                    .show()
            }
        }

    }

    private suspend fun progress(progressBar: ProgressBar){
        while (progressBar.progress < progressBar.max) {
            delay(500)
            progressBar.incrementProgressBy(PROGRESS_INCREMENT)
        }
        if (progressBar.progress == 100)
            cargando = false
    }

    private fun generarColorAleatorio() : Int{
        var rndm = Random()
        return Color.argb(255, rndm.nextInt(256), rndm.nextInt(256), rndm.nextInt(256))
    }

    companion object{
        const val PROGRESS_INCREMENT = 5
    }
}