package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputName = findViewById<TextView>(R.id.inputName)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val intent = Intent(this, BMIActivity::class.java)

            intent.putExtra("Name",inputName.text.toString())
            startActivity(intent)
        }
    }
}