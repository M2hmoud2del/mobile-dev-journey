package com.example.endangeredanimals

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(val activity: Activity, val animals: List<Animal>) :
    RecyclerView.Adapter<AnimalAdapter.AnimalVH>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimalVH {
        val inflatedView = activity.layoutInflater
            .inflate(
                R.layout.animal_list_item,
                parent,
                false
            )
        return AnimalVH(inflatedView)
    }

    override fun onBindViewHolder(
        holder: AnimalVH,
        position: Int
    ) {
        holder.animalIV.setImageResource(animals[position].image)
        holder.animalNameTV.text = activity.getString(animals[position].name)
        if(animals[position].bg == Constants.SEA_BG) holder.bgIV.setImageResource(R.drawable.sea)
        else holder.bgIV.setImageResource(R.drawable.forest)

        holder.container.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW,animals[position].website.toUri())
            activity.startActivity(i)
        }
    }

    override fun getItemCount() = animals.size

    class AnimalVH(v: View) : RecyclerView.ViewHolder(v) {
        val container: CardView = v.findViewById(R.id.animal_container_cv)
        val animalIV: ImageView = v.findViewById(R.id.animal_iv)
        val animalNameTV: TextView = v.findViewById(R.id.name_tv)
        val bgIV: ImageView = v.findViewById(R.id.bg_iv)
    }

}