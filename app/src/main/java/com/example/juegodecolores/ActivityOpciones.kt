package com.example.juegodecolores

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_juego.*
import kotlinx.android.synthetic.main.activity_opciones.*
import kotlinx.coroutines.launch
import java.util.*

class ActivityOpciones : AppCompatActivity() {

    private var jugadaActual = 0
    private var puntaje = 0
    private var opcionCorrecta = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)

        val colorCorrecto = intent.getIntExtra("colorGenerado",0)
        jugadaActual = intent.getIntExtra("jugadaActual",0)
        puntaje = intent.getIntExtra("puntaje",0)
        Toast.makeText(this,puntaje.toString(),Toast.LENGTH_SHORT).show()

        val rndm = Random().nextInt(4)
        opcionCorrecta = rndm
        when(rndm){
            0 -> {opcion1.setBackgroundColor(colorCorrecto)
                 opcion2.setBackgroundColor(generarColorAleatorio())
                 opcion3.setBackgroundColor(generarColorAleatorio())
                 opcion4.setBackgroundColor(generarColorAleatorio())
            }
            1 -> {opcion1.setBackgroundColor(generarColorAleatorio())
                opcion2.setBackgroundColor(colorCorrecto)
                opcion3.setBackgroundColor(generarColorAleatorio())
                opcion4.setBackgroundColor(generarColorAleatorio())
            }
            2 -> {opcion1.setBackgroundColor(generarColorAleatorio())
                opcion2.setBackgroundColor(generarColorAleatorio())
                opcion3.setBackgroundColor(colorCorrecto)
                opcion4.setBackgroundColor(generarColorAleatorio())
            }
            3 -> {opcion1.setBackgroundColor(generarColorAleatorio())
                opcion2.setBackgroundColor(generarColorAleatorio())
                opcion3.setBackgroundColor(generarColorAleatorio())
                opcion4.setBackgroundColor(colorCorrecto)
            }
        }

        opcion1.setOnClickListener {
            if (rndm == 0){
                AlertDialog.Builder(this)
                    .setTitle("Respuesta Correcta")
                    .setIcon(R.drawable.check_icon)
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                        puntaje += 10
                        println(puntaje)
                        jugadaActual++
                        val intent = Intent(this,JuegoActivity::class.java)
                        intent.putExtra("puntaje",puntaje)
                        intent.putExtra("jugadaActual",jugadaActual)
                        startActivity(intent)
                        this.finish()
                    }
                    .show()
            }else{
                AlertDialog.Builder(this)
                    .setTitle("Respuesta Incorrecta")
                    .setIcon(R.drawable.uncheck_icon)
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                        jugadaActual++
                        val intent = Intent(this,JuegoActivity::class.java)
                        intent.putExtra("puntaje",puntaje)
                        intent.putExtra("jugadaActual",jugadaActual)
                        startActivity(intent)
                        this.finish()
                    }
                    .show()
            }
        }

        opcion2.setOnClickListener {
            if (rndm == 1){
                AlertDialog.Builder(this)
                    .setTitle("Respuesta Correcta")
                    .setIcon(R.drawable.check_icon)
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                        puntaje += 10
                        println(puntaje)
                        jugadaActual++
                        val intent = Intent(this,JuegoActivity::class.java)
                        intent.putExtra("puntaje",puntaje)
                        intent.putExtra("jugadaActual",jugadaActual)
                        startActivity(intent)
                        this.finish()
                    }
                    .show()
            }else{
                AlertDialog.Builder(this)
                    .setTitle("Respuesta Incorrecta")
                    .setIcon(R.drawable.uncheck_icon)
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                        jugadaActual++
                        val intent = Intent(this,JuegoActivity::class.java)
                        intent.putExtra("puntaje",puntaje)
                        intent.putExtra("jugadaActual",jugadaActual)
                        startActivity(intent)
                        this.finish()
                    }
                    .show()
            }
        }

        opcion3.setOnClickListener {
            if (rndm == 2){
                AlertDialog.Builder(this)
                    .setTitle("Respuesta Correcta")
                    .setIcon(R.drawable.check_icon)
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                        puntaje += 10
                        println(puntaje)
                        jugadaActual++
                        val intent = Intent(this,JuegoActivity::class.java)
                        intent.putExtra("puntaje",puntaje)
                        intent.putExtra("jugadaActual",jugadaActual)
                        startActivity(intent)
                        this.finish()
                    }
                    .show()
            }else{
                AlertDialog.Builder(this)
                    .setTitle("Respuesta Incorrecta")
                    .setIcon(R.drawable.uncheck_icon)
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                        jugadaActual++
                        val intent = Intent(this,JuegoActivity::class.java)
                        intent.putExtra("puntaje",puntaje)
                        intent.putExtra("jugadaActual",jugadaActual)
                        startActivity(intent)
                        this.finish()
                    }
                    .show()
            }
        }

        opcion4.setOnClickListener {
            if (rndm == 3){
                AlertDialog.Builder(this)
                    .setTitle("Respuesta Correcta")
                    .setIcon(R.drawable.check_icon)
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                        puntaje += 10
                        println(puntaje)
                        jugadaActual++
                        val intent = Intent(this,JuegoActivity::class.java)
                        intent.putExtra("puntaje",puntaje)
                        intent.putExtra("jugadaActual",jugadaActual)
                        startActivity(intent)
                        this.finish()
                    }
                    .show()
            }else{
                AlertDialog.Builder(this)
                    .setTitle("Respuesta Incorrecta")
                    .setIcon(R.drawable.uncheck_icon)
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                        jugadaActual++
                        val intent = Intent(this,JuegoActivity::class.java)
                        intent.putExtra("puntaje",puntaje)
                        intent.putExtra("jugadaActual",jugadaActual)
                        startActivity(intent)
                        this.finish()
                    }
                    .show()
            }
        }


    }

    private fun generarColorAleatorio() : Int{
        var rndm = Random()
        return Color.argb(255, rndm.nextInt(256), rndm.nextInt(256), rndm.nextInt(256))
    }
}