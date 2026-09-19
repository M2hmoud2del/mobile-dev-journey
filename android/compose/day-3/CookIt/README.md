# CookIt

CookIt is a small Android app built with Kotlin and Jetpack Compose to browse food categories and meals from TheMealDB.

## Overview
The app loads categories from the API, lets the user choose a category, and then displays the matching meals in a clean card-based grid. The interface is built using Material 3 and modern Compose patterns.

## Features implemented
- Category list fetched from TheMealDB API
- Meal list loaded by selected category
- Responsive two-column meal grid
- Food cards with image, title, and modern layout styling
- Error handling with Toast messages for network or fetch failures
- Clean Compose UI using Material 3

## Tech stack
- Kotlin
- Jetpack Compose
- Material 3
- Retrofit
- Gson
- Coil

## Improvements included in the project
The project already includes a few code-quality improvements that make the app cleaner and easier to maintain:

### 1. Lazy Retrofit initialization
The Retrofit instance is created using lazy initialization instead of being created immediately when the object is loaded.

This helps by:
- delaying object creation until it is actually needed
- avoiding unnecessary work at startup
- keeping the singleton setup efficient

### 2. Centralized API constants
The project stores API URLs and JSON field names in a dedicated constants object to avoid repeated hardcoded strings.

This makes the app easier to maintain and reduces the risk of mismatched values.

### 3. JSON field mapping with SerializedName
The data models use Gson annotations to map API response fields to cleaner Kotlin property names.

Example:
- idCategory -> id
- strCategory -> name
- strCategoryThumb -> imageURL

This keeps the app code more readable while still matching the external API contract.

## App flow
1. The app loads available categories from the API.
2. The user selects a category.
3. The matching meals are fetched and displayed.
4. The selected meal data is shown in a card layout.

## Project structure
- app/src/main/java/com/excercise/cookit/MainActivity.kt – app entry point and Compose setup
- app/src/main/java/com/excercise/cookit/api/RetrofitInstance.kt – lazy Retrofit singleton
- app/src/main/java/com/excercise/cookit/api/FoodAPICallable.kt – API endpoints
- app/src/main/java/com/excercise/cookit/data/ – response and model classes
- app/src/main/java/com/excercise/cookit/ui/ – reusable Compose UI components

## Run the app
1. Open the project in Android Studio.
2. Sync Gradle files.
3. Run the app on an emulator or connected device.

## Notes
This project is a simple Compose-based example focused on learning API integration, state management, and UI composition in Android development.
