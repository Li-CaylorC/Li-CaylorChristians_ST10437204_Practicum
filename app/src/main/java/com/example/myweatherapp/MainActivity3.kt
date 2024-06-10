package com.example.myweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        this.title = "Back"

        val insertDays = intent.getStringArrayListExtra("insertDays")
        val mins = intent.getIntegerArrayListExtra("mins")
        val maxs = intent.getIntegerArrayListExtra("maxs")
        val weatherCons = intent.getStringArrayListExtra("weatherCons")

        val tvResult : TextView = findViewById(R.id.tvResults)
        val summaryText = StringBuilder()

        if (insertDays != null && mins != null && maxs != null && weatherCons != null) {
            for (i in insertDays.indices) {
                summaryText.append("Day: ${insertDays[i]}\nMin Temp: ${mins[i]}\nMax Temp: ${maxs[i]}\nWeather Condition: ${weatherCons[i]}\n\n")
            }
        } else {
            summaryText.append("No data available")
        }

        tvResult.text = summaryText.toString()
    }
}
