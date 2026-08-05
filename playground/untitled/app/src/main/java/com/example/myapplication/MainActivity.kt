package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.college.Student
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

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
        Log.d("lifecycle","On Create...")
        Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show()

        val btn: MaterialButton = findViewById(R.id.check_btn)
        val container: TextInputLayout = findViewById(R.id.password_container_til)
        val passwordET: EditText = findViewById(R.id.password_input)
        val resultIV: ImageView = findViewById(R.id.result_iv)

        btn.setOnClickListener {
            resultIV.setImageResource(android.R.color.transparent)
            container.error = $$""
            container.boxStrokeColor = Color.parseColor("#4C4C4C")
            val pass = passwordET.text.toString()
            if(pass.isBlank()) container.error = "Required!"
            else if(pass.length < 6) Toast.makeText(this, "Short password!", Toast.LENGTH_SHORT).show();
            else {
                val result = calculatePasswordScore(pass)
                when(result){
                    1 -> {
                        container.boxStrokeColor = Color.parseColor("#ff0000")
                        resultIV.setImageResource(R.drawable.weak_password)
                    }
                    2 -> {
                        container.boxStrokeColor = Color.parseColor("#f09b05")
                        resultIV.setImageResource(R.drawable.medium_password)
                    }
                    3 -> {
                        container.boxStrokeColor = Color.parseColor("#04de3b")
                        resultIV.setImageResource(R.drawable.strong_password)
                    }
                }
            }
        }
    }
    fun calculatePasswordScore(pass: String): Int {
        var score = 0
        if (Regex("[a-z]").containsMatchIn(pass)) score++
        if (Regex("[A-Z]").containsMatchIn(pass)) score++
        if (Regex("[@#\$%^&+=!]").containsMatchIn(pass)) score++

        return score
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifecycle","On Start...")
    }
    override fun onResume() {
        super.onResume()
        Log.d("lifecycle","On Resume...")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle","On Destroy...")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifecycle","On Pause...")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("lifecycle","On Restart...")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifecycle","On Stop...")
    }
}