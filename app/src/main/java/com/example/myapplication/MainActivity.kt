package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.sp_languages)
        val textView: TextView = findViewById(R.id.helloworld)

        val languageKeys = resources.getStringArray(R.array.language_keys)
        val languageValues = resources.getStringArray(R.array.language_values)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languageValues)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedLanguageKey = languageKeys[position]
                val greetingResId = when (selectedLanguageKey) {
                    "port" -> R.string.portugues
                    "ger" -> R.string.german
                    "eng" -> R.string.english
                    "spn" -> R.string.spanish
                    else -> R.string.portugues
                }
                textView.text = getString(greetingResId)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
}
