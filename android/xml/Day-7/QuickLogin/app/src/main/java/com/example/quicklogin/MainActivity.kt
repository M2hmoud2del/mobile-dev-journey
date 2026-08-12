package com.example.quicklogin

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val emailET: EditText = findViewById(R.id.email_et)
        val passET: EditText = findViewById(R.id.pass_et)
        val loginBtn: Button = findViewById(R.id.login_btn)
        val rememberCB: CheckBox = findViewById(R.id.remember_credentials_cb)

        loginBtn.setOnClickListener {
            val email = emailET.text.toString()
            val password = passET.text.toString()
            val re = Regex("([a-zA-Z0-9])+@(A-Za-z)+.([a-zA-Z]{2,3})")
            val isValidEmail = email.matches(re)

            if(isValidEmail){
                if(rememberCB.isChecked){
                    // Save Data
                }else{
                    // Delete Data
                }
            }else{
                Toast.makeText(this, "The email address you entered is invalid. Please try again.", Toast.LENGTH_SHORT).show();
            }

        }

    }
}