# Banque Misr Login UI

A small Android app that recreates a Banque Misr-style login screen using Jetpack Compose. This project is part of an Android Compose learning journey.

## Built Features

- Username and password input fields
- Password visibility toggle
- Login button enabled only when both fields contain text
- English and Arabic language switching
- Forgot username/password text and support link styling
- Quick-access cards for products, exchange rates, security tips, and branches/ATMs
- Edge-to-edge layout with scrolling support for smaller screens
- Compose preview for the login screen

> This is currently a UI exercise. Login, support links, and quick-access cards do not connect to a backend yet.

## Tech Stack

- Kotlin
- Jetpack Compose
- Material 3
- AndroidX Activity Compose
- AndroidX AppCompat for locale switching
- Gradle Kotlin DSL and version catalogs
- JUnit, Espresso, and Compose UI testing dependencies

## Requirements

- Android Studio with Android SDK 37
- JDK 11 or newer
- Android device or emulator running Android 11 / API 30 or newer

## Run the Project

1. Open the project in Android Studio.
2. Let Gradle sync and install any requested SDK components.
3. Run the `app` configuration on an emulator or connected Android device.

From the project root, the debug APK can also be built with:

```bash
./gradlew assembleDebug
```

On Windows:

```powershell
.\gradlew.bat assembleDebug
```

## Project Structure

```text
app/src/main/java/com/excercise/banquemisr/
├── MainActivity.kt          # Compose entry point and login screen
└── ui/theme/                # Theme, colors, typography, and reusable cards
```
