# 🎴 Card Clash 2P

![Android](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Language-Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Min SDK](https://img.shields.io/badge/Min%20SDK-30%20(Android%2011)-blue?style=for-the-badge)
![Target SDK](https://img.shields.io/badge/Target%20SDK-37-orange?style=for-the-badge)

A dynamic, 2-player turn-based card game for Android built natively using **Kotlin** and **XML layouts**. **Card Clash 2P** delivers a high-speed, head-to-head card draw competition wrapped in a modern tech-inspired dark interface.

---

## 🌟 Features

- 🎮 **2-Player Local Multiplayer**: Play head-to-head on a single Android device.
- 🎲 **Randomized Card Battles**: Draw cards numbered **0–9** and compete for the highest card each round.
- 🏁 **5-Round Match System**: Play through 5 strategic rounds to determine the ultimate winner.
- 🏆 **Dynamic Scoring System**: 
  - Winning a round grants **+10 points**.
  - Ties award **+10 points** to both players.
  - Final winner announcement at the completion of round 5.
- 🎨 **Modern Dark UI Design System**: Built with a custom design system featuring deep navy backgrounds (`#0B1326`), vibrant cyan accents (`#22D3EE`), and geometric **Poppins** typography.
- 🗣️ **Bilingual Gameplay Messages**: Engaging round and match outcome notifications in both English and Arabic.

---

## 📸 Screenshots & Demos

| UI Design Screenshot | Demo Video |
| :---: | :---: |
| ![UI Screen](UI%20Design/screen.png) | [Watch Gameplay Video](video/Screen_recording_20260806_173227.webm) |

---

## 🕹️ How to Play

1. **Start Match**: Both players start with 0 points across 5 rounds.
2. **Player 1 Turn**: Tap **"Player 1: Draw Card"** to draw a random card (`0`–`9`).
3. **Player 2 Turn**: Tap **"Player 2: Draw Card"** to reveal Player 2's card.
4. **Round Outcome**:
   - Higher card number wins **10 points**.
   - Identical card numbers result in a tie (both gain **10 points**).
5. **Next Round**: Tap to advance through rounds 1 to 5.
6. **Victory**: The player with the highest overall score at the end of Round 5 is crowned champion!

---

## 🛠️ Tech Stack & Architecture

- **Language**: [Kotlin](https://kotlinlang.org/)
- **UI Architecture**: Native Android XML (`ConstraintLayout`, `MaterialComponents`)
- **Min SDK**: `30` (Android 11)
- **Target / Compile SDK**: `37`
- **Build Tool**: Gradle with Kotlin DSL (`build.gradle.kts`)
- **Design System Spec**: 8dp Grid system, dark theme palette, Poppins font family (`UI Design/DESIGN.md`)

---

## 📁 Repository Structure

```
CardClash2P/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/cardclash2p/
│   │       │   └── MainActivity.kt        # Game loop, turn state machine & scoring logic
│   │       ├── res/
│   │       │   ├── drawable/              # Card assets (card_0 .. card_9, question_mark_card)
│   │       │   ├── font/                  # Poppins font files
│   │       │   ├── layout/
│   │       │   │   └── activity_main.xml  # ConstraintLayout game UI structure
│   │       │   └── values/                # Colors, strings, themes
│   │       └── AndroidManifest.xml
│   └── build.gradle.kts                   # App dependencies & SDK versions
├── UI Design/
│   ├── DESIGN.md                          # UI design system & token definitions
│   ├── code.html                          # HTML visual layout reference
│   └── screen.png                         # High-res UI screenshot
├── video/
│   └── Screen_recording_20260806_173227.webm # Gameplay video demonstration
├── build.gradle.kts                       # Root build configuration
├── settings.gradle.kts                    # Gradle repositories & project naming
└── README.md                              # Application documentation
```

---

## 🚀 Getting Started

### Prerequisites

- [Android Studio](https://developer.android.com/studio) (Hedgehog / Iguana or newer)
- JDK 11 or higher
- Android Device or Emulator running Android 11+ (API Level 30+)

### Building & Running

1. **Clone the repository**:
   ```bash
   git clone https://github.com/M2hmoud2del/mobile-dev-journey.git
   cd android/xml/Day-4/CardClash2P
   ```

2. **Open in Android Studio**:
   - Launch Android Studio and click **Open**.
   - Select the `CardClash2P` directory.

3. **Build & Execute**:
   - Allow Gradle to sync.
   - Run on an connected device or emulator using **Shift + F10**, or build the APK via CLI:
     ```bash
     ./gradlew assembleDebug
     ```

---

## 📄 License

This repository is part of the **Mobile Dev Journey** series. Created for Android development learning and demonstration.
