package com.excercise.emergencyapp

import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class EmergencyAdapter(val activity: Activity,val emergencyContacts: List<EmergencyContact>): RecyclerView.Adapter<EmergencyAdapter.EmergencyVH>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmergencyVH {
        val inflatedView = activity.layoutInflater.inflate(R.layout.item_emergency_contact,parent,false)
        return EmergencyVH(inflatedView)
    }

    override fun onBindViewHolder(
        holder: EmergencyVH,
        position: Int
    ) {
        holder.iconBackgroundV.backgroundTintList =  ColorStateList.valueOf(activity.getColor(emergencyContacts[position].iconColor))
        holder.contactIconIV.setImageResource(emergencyContacts[position].contactIcon)
        holder.contactIconIV.imageTintList = ColorStateList.valueOf(activity.getColor(emergencyContacts[position].contactIconColor))
        holder.serviceNameTV.text = activity.getString(emergencyContacts[position].name)
        holder.serviceCategoryTV.text = activity.getString(emergencyContacts[position].category)
        holder.phoneNumberTV.text = emergencyContacts[position].phoneNumber.toString()
        holder.callButtonFAB.setOnClickListener {
            val i = Intent(Intent.ACTION_DIAL).apply {
                val phoneUri = Uri.parse("tel:${emergencyContacts[position].phoneNumber}")
                data = phoneUri
            }
            activity.startActivity(i)
        }
    }

    override fun getItemCount() = emergencyContacts.size

    class EmergencyVH(v: View): RecyclerView.ViewHolder(v){
        val iconBackgroundV : View = v.findViewById(R.id.iconBackground)
        val contactIconIV : ImageView = v.findViewById(R.id.contactIcon)
        val serviceNameTV : TextView = v.findViewById(R.id.serviceName)
        val serviceCategoryTV : TextView = v.findViewById(R.id.serviceCategory)
        val phoneNumberTV : TextView = v.findViewById(R.id.phoneNumber)
        val callButtonFAB : FloatingActionButton = v.findViewById(R.id.callButton)
    }


}