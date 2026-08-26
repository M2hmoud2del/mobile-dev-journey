package com.excercise.emergencyapp

object Constants {

    val emergencyContactsList = listOf(
        EmergencyContact(
            name = R.string.police,
            category = R.string.law_enforcement,
            phoneNumber = 122,
            contactIcon = R.drawable.local_police_24px,
            contactIconColor = R.color.police_icon_tint,
            iconColor = R.color.police_icon_bg
        ),
        EmergencyContact(
            name = R.string.ambulance,
            category = R.string.medical_emergency,
            phoneNumber = 123,
            contactIcon = R.drawable.ambulance_24px,
            contactIconColor = R.color.ambulance_icon_tint,
            iconColor = R.color.ambulance_icon_bg
        ),
        EmergencyContact(
            name = R.string.fire_department,
            category = R.string.fire_rescue,
            phoneNumber = 180,
            contactIcon = R.drawable.local_fire_department_24px,
            contactIconColor = R.color.fire_icon_tint,
            iconColor = R.color.fire_icon_bg
        ),
        EmergencyContact(
            name = R.string.electricity_emergency,
            category = R.string.utility_service,
            phoneNumber = 121,
            contactIcon = R.drawable.electric_bolt_24px,
            contactIconColor = R.color.electricity_icon_tint,
            iconColor = R.color.electricity_icon_bg
        ),
        EmergencyContact(
            name = R.string.gas_emergency,
            category = R.string.utility_service,
            phoneNumber = 129,
            contactIcon = R.drawable.mode_heat_24px,
            contactIconColor = R.color.gas_icon_tint,
            iconColor = R.color.gas_icon_bg
        )
    )
}