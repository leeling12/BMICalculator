package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_b_m_i.*

class BMIActivity : AppCompatActivity() {
    var bmiIndex: Double = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_m_i)


        val name = intent?.getStringExtra("Name")

        val textView = findViewById<TextView>(R.id.personName);
        textView.setText(name);



        if(savedInstanceState!=null){
            savedInstanceState.getDouble("bmiIndex")

            val tvStatus = findViewById<TextView>(R.id.tvStatus)
            tvStatus.setText(getStatus())
        }


        val btn = findViewById<Button>(R.id.btnCalculate)

        btn.setOnClickListener {
            val weight = findViewById<TextView>(R.id.inputWeight).text.toString()
            val height = findViewById<TextView>(R.id.inputHeight).text.toString()
            val tvStatus = findViewById<TextView>(R.id.tvStatus)

            bmiIndex = weight.toDouble() / (height.toDouble() * height.toDouble())

            tvStatus.setText(getStatus())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putDouble("bmiIndex", bmiIndex)
    }

    fun getStatus():String{
        if(bmiIndex < 18.5)
            return "Underweight"
        else if(bmiIndex < 24.9)
            return "Normal weight"
        else if(bmiIndex < 29.9)
            return "Overweight"
        else if(bmiIndex < 34.9)
            return "Obesity class I"
        else if(bmiIndex < 39.9)
            return "Obesity class II"
        else
            return "Obesity class III"
    }
}