package com.example.weatherapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import coil.load

class MainActivity : AppCompatActivity() {

    lateinit var city: EditText
    private val time = System.currentTimeMillis() / 1000
    lateinit var button: Button
    lateinit var imageView: ImageView
    lateinit var error: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        imageView = findViewById(R.id.image)
        city = findViewById(R.id.city)
        button = findViewById(R.id.go)
        error = findViewById(R.id.error)

        button.setOnClickListener { v ->
            val place: String = city.text.toString()
            try {
                imageView.load("https://vwapi.mxf.su/?lang=ru&city=$place&timestamp=$time")
                error.visibility = View.INVISIBLE
            } catch (_: Exception){
                error.visibility = View.VISIBLE
            }


        }
    }
}