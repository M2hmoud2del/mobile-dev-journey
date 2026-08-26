# 🚨 Emergency Contacts App (Android)

A modern Android application built with **Kotlin** and **XML layouts** that provides quick, reliable access to essential emergency services (Police, Ambulance, Fire Department, Electricity, and Gas Emergency). The app features a dynamic `RecyclerView` layout, custom item styling with color coding per service, and direct one-tap dialing via Android implicit intents.

---

## 📱 Features

- **One-Tap Dialing**: Instant action using Android `Intent.ACTION_DIAL` to open the system dialer pre-populated with emergency numbers.
- **Emergency Service Hotline List**:
  - 👮 **Police** (`122`) – Law Enforcement
  - 🚑 **Ambulance** (`123`) – Medical Emergency
  - 🚒 **Fire Department** (`180`) – Fire & Rescue
  - ⚡ **Electricity Emergency** (`121`) – Utility Service
  - 🔥 **Gas Emergency** (`129`) – Utility Service
- **Dynamic RecyclerView**: Memory-efficient list rendering using custom `EmergencyAdapter` and `ViewHolder`.
- **Material Design 3 Components**: Cards (`MaterialCardView`), toolbars (`MaterialToolbar`), and mini call FABs (`FloatingActionButton`).
- **Custom Visual Identity**: Unique vector drawables, dynamic icon color tinting, and circular icon avatar backgrounds for each emergency type.
- **Edge-to-Edge Layout**: Window insets handling for modern Android UI integration.

---

## 🛠️ Tech Stack & Requirements

- **Language**: Kotlin
- **UI Architecture**: Android XML Layouts & ConstraintLayout
- **Components**: Material Components for Android (`com.google.android.material`)
- **Min SDK**: `30` (Android 11)
- **Target SDK**: `37`
- **Gradle Plugins**: Android Application Plugin

---

## 📁 Codebase Structure

```
emergency-app/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/excercise/emergencyapp/
│           │   ├── MainActivity.kt        # Entry activity setting up edge-to-edge & RecyclerView
│           │   ├── EmergencyAdapter.kt    # Adapter binding views & setting dial intents
│           │   ├── EmergencyContact.kt    # Model data class holding contact attributes
│           │   └── Constants.kt           # Static repository of emergency contacts data
│           └── res/
│               ├── layout/
│               │   ├── activity_main.xml          # Main screen with Toolbar & RecyclerView
│               │   └── item_emergency_contact.xml # Card view layout for individual contact
│               ├── drawable/                      # Custom vector icons & background shapes
│               └── values/                        # Color definitions, strings, & themes
└── video/                                         # Application screencast demo
```

---

## 🔑 Key Implementations & Highlights

1. **Data Model & Centralized Repository**:
   - [`EmergencyContact.kt`](app/src/main/java/com/excercise/emergencyapp/EmergencyContact.kt): Model encapsulating `@StringRes` name and category, hotline `phoneNumber`, `@DrawableRes` icon, and `@ColorRes` tinting properties.
   - [`Constants.kt`](app/src/main/java/com/excercise/emergencyapp/Constants.kt): Provides `emergencyContactsList` containing pre-configured emergency services.

2. **Custom RecyclerView Adapter & Dialing Intent**:
   - [`EmergencyAdapter.kt`](app/src/main/java/com/excercise/emergencyapp/EmergencyAdapter.kt): Inflates card views, dynamically sets icon tinting via `ColorStateList`, and attaches an `OnClickListener` to the Call FAB that fires an implicit intent:
     ```kotlin
     val i = Intent(Intent.ACTION_DIAL).apply {
         data = Uri.parse("tel:${emergencyContacts[position].phoneNumber}")
     }
     activity.startActivity(i)
     ```

3. **User Interface & Layouts**:
   - [`activity_main.xml`](app/src/main/res/layout/activity_main.xml): Features a Material toolbar header and full-screen `RecyclerView`.
   - [`item_emergency_contact.xml`](app/src/main/res/layout/item_emergency_contact.xml): Elevates each contact using `MaterialCardView`, customizable icon badge, service details, hotline number highlighted in red, and a prominent red call FAB.

4. **String Localization & Color Palette**:
   - Resource strings organized in [`strings.xml`](app/src/main/res/values/strings.xml).
   - Dedicated service color schemes in [`colors.xml`](app/src/main/res/values/colors.xml) for quick visual identification.

---

## 📹 Demo Video

A screencast recording showcasing the application UI and interaction is included in the project under [`video/`](video/):
- `video/Screencast From 2026-08-26 14-06-31.mp4`
