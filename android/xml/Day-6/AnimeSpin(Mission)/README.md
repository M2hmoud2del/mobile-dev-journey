# 🎌 AnimeSpin (Mission)

![Android](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Language-Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Min SDK](https://img.shields.io/badge/Min%20SDK-30%20(Android%2011)-blue?style=for-the-badge)
![Target SDK](https://img.shields.io/badge/Target%20SDK-36-orange?style=for-the-badge)

A native Android application built with **Kotlin** and **XML Layouts** demonstrating dropdown selection using `Spinner`, adapter binding (`ArrayAdapter`), and web navigation via implicit `Intent` execution (`Intent.ACTION_VIEW`).

This project is part of the **Mobile Dev Journey (Day 6 - Android XML)**.

---

## 🌟 Features

- 🌀 **Interactive Anime Dropdown (`Spinner`)**: Select from a curated list of top 20 anime series and Studio Ghibli films (*Hunter X Hunter*, *One Piece*, *Attack on Titan*, *Jujutsu Kaisen*, *Spirited Away*, and more).
- 🌐 **Implicit Intent Web Search**: Triggers an implicit `Intent(Intent.ACTION_VIEW)` to open a Google Search query for the selected anime in the default web browser.
- 🛡️ **Initialization Guard**: Prevents unwanted search triggers during spinner layout binding using a initial-selection state flag (`isFirstSelection`).
- ⚠️ **Exception & Fallback Handling**: Safely catches `ActivityNotFoundException` with a `Toast` fallback when no web browser application is installed on the device.
- 🔔 **Toast Feedback**: Displays immediate UI feedback notifying the user of their selected title.
- 📱 **Edge-to-Edge Display**: Integrated with `WindowInsetsCompat` for seamless UI rendering on modern Android devices.

---

## 🎬 Demo Video

A screen recording demonstrating the user interface and browser navigation flow is available under the [`video/`](video/) directory:

- 📹 **Demo Recording**: [`video/Screen_recording_20260811_064740.mp4`](video/Screen_recording_20260811_064740.mp4)

---

## 🛠️ Tech Stack & Specifications

- **Language**: [Kotlin](https://kotlinlang.org/)
- **UI Architecture**: Native Android XML (`LinearLayout`, `Spinner`, `TextView`)
- **Adapters & Callbacks**: `ArrayAdapter`, `AdapterView.OnItemSelectedListener`
- **Intents**: Implicit `Intent` (`Intent.ACTION_VIEW`) with Uri parsing
- **Min SDK**: `30` (Android 11)
- **Target SDK**: `36` (Compile SDK 37)
- **Build Tool**: Gradle with Kotlin DSL (`build.gradle.kts`)

---

## 📁 Project Structure

```text
AnimeSpin(Mission)/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/animespin/
│   │       │   └── MainActivity.kt        # Spinner binding, OnItemSelectedListener & Intent logic
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   │   └── activity_main.xml  # UI layout with TextView & Spinner
│   │       │   └── values/                # Strings, colors, styles
│   │       └── AndroidManifest.xml        # Application manifest & launcher entry
│   └── build.gradle.kts                   # App dependencies & SDK versions
├── video/
│   └── Screen_recording_20260811_064740.mp4 # Video demonstration
├── build.gradle.kts                       # Root build script
├── settings.gradle.kts                    # Project build settings
└── README.md                              # Project documentation
```

---

## 🚀 How to Run

### Prerequisites

- [Android Studio](https://developer.android.com/studio) (Ladybug / Hedgehog or newer)
- JDK 11 or higher
- Android Device or Emulator running Android 11+ (API Level 30+)

### Building & Running

1. **Clone the repository**:
   ```bash
   git clone https://github.com/M2hmoud2del/mobile-dev-journey.git
   cd android/xml/Day-6/AnimeSpin\(Mission\)
   ```

2. **Open in Android Studio**:
   - Launch Android Studio and click **Open**.
   - Select the `AnimeSpin(Mission)` directory.

3. **Build & Execute**:
   - Allow Gradle to complete synchronization.
   - Run on your connected device or emulator (`Shift + F10`), or build via CLI:
     ```bash
     ./gradlew assembleDebug
     ```

---

## 📄 License

This project is part of the **Mobile Dev Journey** learning repository. Built for Android development exploration and practice.
