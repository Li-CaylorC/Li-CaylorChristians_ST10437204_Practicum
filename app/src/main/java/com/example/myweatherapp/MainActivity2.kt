package com.example.myweatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    private lateinit var etInsertDay: EditText
    private lateinit var etMin: EditText
    private lateinit var etMax: EditText
    private lateinit var etWeatherCon: EditText

    private val insertDays = ArrayList<String>()
    private val mins = ArrayList<Int>()
    private val maxs = ArrayList<Int>()
    private val weatherCons = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        this.title = "Back"

        etInsertDay = findViewById(R.id.etInsertDay)
        etMin = findViewById(R.id.etMin)
        etMax = findViewById(R.id.etMax)
        etWeatherCon = findViewById(R.id.etWeatherCon)

        val addDatabtn: Button = findViewById(R.id.addDatabtn)
        val viewSumbtn: Button = findViewById(R.id.viewSumBtn)
        val clearBtn: Button = findViewById(R.id.clearBtn)

        clearBtn.setOnClickListener {
            clearText()
        }

        addDatabtn.setOnClickListener {
            saveData()
        }

        viewSumbtn.setOnClickListener {
            viewSummaryData()
        }
    }

    private fun clearText() {
        etInsertDay.setText("")
        etMin.setText("")
        etMax.setText("")
        etWeatherCon.setText("")
    }

    private fun viewSummaryData() {
        val intent = Intent(applicationContext, MainActivity3::class.java)
        intent.putStringArrayListExtra("insertDays", insertDays)
        intent.putIntegerArrayListExtra("mins", mins)
        intent.putIntegerArrayListExtra("maxs", maxs)
        intent.putStringArrayListExtra("weatherCons", weatherCons)
        startActivity(intent)
    }

    private fun saveData() {
        val insertDay = etInsertDay.text.toString()
        val min = etMin.text.toString().toIntOrNull()
        val max = etMax.text.toString().toIntOrNull()
        val weatherCon = etWeatherCon.text.toString()

        if (insertDay.isNotEmpty() && min != null && max != null && weatherCon.isNotEmpty()) {
            insertDays.add(insertDay)
            mins.add(min)
            maxs.add(max)
            weatherCons.add(weatherCon)
            clearText()
            Toast.makeText(this, "Data saved successfully", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Please fill all fields correctly", Toast.LENGTH_LONG).show()
        }
    }
}






