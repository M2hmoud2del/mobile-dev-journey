# CookIt

A small Android app built with Kotlin and Jetpack Compose to explore food categories and meals from TheMealDB.

## What I built
- Created a clean Compose UI for a food app home screen.
- Fetched food categories from the MealDB API using Retrofit.
- Selected a category to load matching meals.
- Displayed meals in a responsive grid with images, titles, and card-style layout.
- Added simple user feedback for loading/network errors using Toast messages.
- Used Coil for image loading and Material 3 for styling.

## Tech stack
- Kotlin
- Jetpack Compose
- Material 3
- Retrofit
- Gson
- Coil

## App flow
1. App loads categories from the API.
2. User taps a category.
3. Meals for that category are fetched and shown.
4. Each meal card displays its image and name.

## Project structure
- `app/src/main/java/com/excercise/cookit/MainActivity.kt` – main screen and app logic
- `app/src/main/java/com/excercise/cookit/api/` – Retrofit API setup
- `app/src/main/java/com/excercise/cookit/data/` – data models for categories and foods
- `app/src/main/java/com/excercise/cookit/ui/` – reusable Compose UI items

## Run it
Open the project in Android Studio and run the app on an emulator or connected device.
