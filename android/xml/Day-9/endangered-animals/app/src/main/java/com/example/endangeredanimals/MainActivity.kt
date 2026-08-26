package com.example.endangeredanimals

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

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

        val animals = mutableListOf<Animal>()

        animals.add(Animal(
            R.string.african_forest_elephant,
            R.drawable.african_forest_elephant,
            Constants.AFRICAN_FOREST_ELEPHANT_URL,
        ))

        animals.add(Animal(
            R.string.amur_leopard,
            R.drawable.amur_leopard,
            Constants.AMUR_LEOPARD_URL,
        ))

        animals.add(Animal(
            R.string.axolotl,
            R.drawable.axolotl,
            Constants.AXOLOTL_URL,
            Constants.SEA_BG
        ))

        animals.add(Animal(
            R.string.javan_rhino,
            R.drawable.javan_rhino,
            Constants.JAVAN_RHINO_URL,
        ))

        animals.add(Animal(
            R.string.mountain_gorilla,
            R.drawable.mountain_gorilla,
            Constants.MOUNTAIN_GORILLA_URL,
        ))

        animals.add(Animal(
            R.string.pangolin,
            R.drawable.pangolin,
            Constants.PANGOLIN_URL,
        ))

        animals.add(Animal(
            R.string.saola,
            R.drawable.saola,
            Constants.SAOLA_URL,
        ))

        animals.add(Animal(
            R.string.sunda_island_tiger,
            R.drawable.sunda_island_tiger,
            Constants.SUNDA_ISLAND_TIGER_URL,
        ))

        animals.add(Animal(
            R.string.tapanuli_orangutan,
            R.drawable.tapanuli_orangutan,
            Constants.TAPANULI_ORANGUTAN_URL,
        ))

        animals.add(Animal(
            R.string.vaquita,
            R.drawable.vaquita,
            Constants.VAQUITA_URL,
            Constants.SEA_BG
        ))

        val adapter = AnimalAdapter(this,animals)

        val animalsRV: RecyclerView = findViewById(R.id.animals_rv)
        animalsRV.setHasFixedSize(true)
        animalsRV.adapter = adapter
    }
}