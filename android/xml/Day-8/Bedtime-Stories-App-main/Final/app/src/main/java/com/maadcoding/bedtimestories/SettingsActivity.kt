package com.maadcoding.bedtimestories

import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val group: RadioGroup = findViewById(R.id.radio_group)
        group.setOnCheckedChangeListener { _, id ->

            val size = when (id) {
                R.id.small_rb_16 -> 16
                R.id.medium_rb_24 -> 24
                else -> 48
            }

            lifecycleScope.launch {
                dataStore.edit {
                    it[UserPreferences.TEXT_SIZE_KEY] = size
                }
            }

        }

        lifecycleScope.launch {
            val prefs = dataStore.data.first()
            val savedSize = prefs[UserPreferences.TEXT_SIZE_KEY]
            Log.d("trace", "Settings Size: $savedSize")
            val radioButtonId = when (savedSize) {
                24 -> R.id.medium_rb_24
                48 -> R.id.large_rb_48
                else -> R.id.small_rb_16
            }
            group.check(radioButtonId)
        }

    }

}