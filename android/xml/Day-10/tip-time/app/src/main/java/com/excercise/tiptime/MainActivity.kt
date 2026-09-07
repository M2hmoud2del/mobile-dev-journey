package com.excercise.tiptime

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.excercise.tiptime.databinding.ActivityMainBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    var total: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        total = savedInstanceState?.getDouble("total") ?: 0.0
        binding.amountTv.text = total.toString()

        binding.calculateBtn.setOnClickListener {
            if (binding.costEt.text!!.isNotEmpty()) {
                val service_cost = binding.costEt.text.toString().toDouble()
                val checkRB = binding.rateRG.checkedRadioButtonId
                val tip = when (checkRB) {
                    R.id.amazing_rb -> .2
                    R.id.good_rb -> .18
                    else -> .15
                }
                total = service_cost * tip
                if(binding.roundSw.isChecked){
                    total = ceil(total)
                }
                binding.amountTv.text = "$${total}"
            }

            Snackbar.make(binding.root,"Reset Everything", BaseTransientBottomBar.LENGTH_LONG)
                .setAction("Proceed"){
                    binding.amountTv.text = "Tip Amount"
                    binding.costEt.text?.clear()
                    binding.roundSw.isChecked = true
                    binding.rateRG.check(R.id.amazing_rb)
                }
                .setBackgroundTint(getColor(android.R.color.holo_green_dark))
                .show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("total",total)
    }
}