# RGB Task - Android Activity Navigation

A native Android application built with **Kotlin** and **XML Layouts** demonstrating explicit Activity navigation and task back-stack management (`FLAG_ACTIVITY_CLEAR_TOP`). 

This project is part of the **Mobile Dev Journey (Day 5 - Android XML)**.

---

## 📱 Application Flow

The app cycles sequentially through three color-themed activities:

1. 🔴 **Red Screen (`MainActivity`)**
   - Displays a red background (`#9E0D0D`).
   - Contains a button **"Show Green"** which triggers an explicit `Intent` to navigate to `GreenActivity`.

2. 🟢 **Green Screen (`GreenActivity`)**
   - Displays a green background (`#00BF1B`).
   - Contains a button **"Show Blue"** which triggers an explicit `Intent` to navigate to `BlueActivity`.

3. 🔵 **Blue Screen (`BlueActivity`)**
   - Displays a blue background (`#1520B1`).
   - Contains a button **"Start Over"** which launches `MainActivity` with `Intent.FLAG_ACTIVITY_CLEAR_TOP`.
   - Clears all intermediate activities (`GreenActivity` and `BlueActivity`) from the back stack, returning the user cleanly to `MainActivity`.

---

## 🎬 Demo Video

A screen recording demonstrating the user interface and activity lifecycle navigation is available under the [`video/`](video/) directory:

- 📹 **Demo Recording**: [`video/Screen_recording_20260809_132613.mp4`](video/Screen_recording_20260809_132613.mp4)

---

## 🛠 Tech Stack & Specifications

- **Language**: Kotlin
- **UI Framework**: Native Android XML (`ConstraintLayout`)
- **Min SDK**: 30 (Android 11)
- **Target SDK**: 36
- **Architecture & APIs**:
  - `AppCompatActivity` & `Edge-to-Edge` UI (`WindowInsetsCompat`)
  - Explicit `Intent` navigation
  - Back-stack flag: `Intent.FLAG_ACTIVITY_CLEAR_TOP`
- **Build System**: Gradle with Kotlin DSL (`build.gradle.kts`)

---

## 📂 Project Structure

```text
rgb/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/rgb_task/
│   │       │   ├── MainActivity.kt     # Red screen logic
│   │       │   ├── GreenActivity.kt    # Green screen logic
│   │       │   └── BlueActivity.kt     # Blue screen logic (with back stack reset)
│   │       ├── res/
│   │       │   └── layout/
│   │       │       ├── activity_main.xml   # Red layout (#9E0D0D)
│   │       │       ├── activity_green.xml  # Green layout (#00BF1B)
│   │       │       └── activity_blue.xml   # Blue layout (#1520B1)
│   │       └── AndroidManifest.xml     # Application manifest & activity registrations
│   └── build.gradle.kts                # App module build configuration
├── video/
│   └── Screen_recording_20260809_132613.mp4  # App demo recording
├── build.gradle.kts                    # Root build configuration
└── README.md
```

---

## 🚀 How to Run

1. Open **Android Studio**.
2. Select **Open an Existing Project** and browse to this directory (`rgb`).
3. Ensure an Android Emulator (API 30+) or physical device with USB Debugging enabled is connected.
4. Click **Run 'app'** (`Shift + F10`) or use the Gradle wrapper from terminal:
   ```bash
   ./gradlew assembleDebug
   ```
