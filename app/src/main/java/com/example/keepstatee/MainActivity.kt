package com.example.keepstatee

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {


    private lateinit var firstNameText: TextView
    private lateinit var lastNameText: TextView
    private lateinit var ageText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        firstNameText = findViewById<TextView>(R.id.idFirstNameText)
        lastNameText = findViewById<TextView>(R.id.idLastNameText)
        ageText = findViewById<TextView>(R.id.idAgeText)


        // UI Elements
        val firstNameField = findViewById<EditText>(R.id.idFirstName)
        val lastNameField = findViewById<EditText>(R.id.idLastName)
        val ageField = findViewById<EditText>(R.id.idAge)
        val display = findViewById<Button>(R.id.idButton)


        firstNameText.isVisible = false
        lastNameText.isVisible = false
        ageText.isVisible = false


        display.setOnClickListener {
            firstNameText.isVisible = true
            lastNameText.isVisible = true
            ageText.isVisible = true
            firstNameText.text = firstNameField.text.toString()
            lastNameText.text = lastNameField.text.toString()
            ageText.text = ageField.text.toString()
        }


    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("first_name", this.firstNameText.text.toString())
        outState.putString("last_name", this.lastNameText.text.toString())
        outState.putString("age", this.ageText.text.toString())
    }


    @SuppressLint("SetTextI18n")
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        firstNameText.isVisible = true
        lastNameText.isVisible = true
        ageText.isVisible = true
        this.firstNameText.text = savedInstanceState.getString("first_name")
        this.lastNameText.text = savedInstanceState.getString("last_name")
        this.ageText.text = savedInstanceState.getString("age")
        Toast.makeText(this, "${this.ageText.text}", Toast.LENGTH_SHORT).show()
    }


}

