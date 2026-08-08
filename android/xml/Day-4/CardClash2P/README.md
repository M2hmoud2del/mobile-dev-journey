# 🎴 Card Clash 2P

A dynamic, 2-player turn-based card game for Android built natively using Kotlin and XML layouts. **Card Clash 2P** delivers a high-speed, head-to-head card draw competition wrapped in a modern tech-inspired dark interface.

---

## 🌟 Features

- 🎮 **2-Player Local Multiplayer**: Turn-based head-to-head gameplay on a single device.
- 🎲 **Randomized Card Battles**: Draw cards numbered **0–9** and compete for the highest card each round.
- 🏁 **5-Round Match System**: Play through 5 strategic rounds to determine the ultimate winner.
- 🏆 **Dynamic Scoring System**: 
  - Winning a round grants **+10 points**.
  - Draws award **+10 points** to both players.
  - Final winner announcement at the end of round 5.
- 🎨 **Modern Dark UI Design**: Built with a custom design system featuring deep navy backgrounds, vibrant cyan accents (`#22D3EE`), and geometric **Poppins** typography.
- 🗣️ **Bilingual Win Messages**: Engaging round and game end announcements (English & Arabic).

---

## 📸 Screenshots & Demos

| UI Design Screenshot | Demo Video |
| :---: | :---: |
| ![UI Screen](UI%20Design/screen.png) | [Watch Gameplay Recording](video/Screen_recording_20260806_173227.webm) |

---

## 🕹️ How to Play

1. **Round Start**: Both players begin with 0 points. The match consists of 5 rounds.
2. **Player 1 Turn**: Tap **"Player 1: Draw Card"** to draw a random card from `0` to `9`.
3. **Player 2 Turn**: Tap **"Player 2: Draw Card"** to reveal Player 2's card.
4. **Round Outcome**:
   - The player with the higher card number wins **10 points**.
   - If both cards match, it's a draw and both get **10 points**.
5. **Advancing**: Tap to move to the next round until Round 5 is completed.
6. **Victory**: The overall winner with the highest score is crowned champion!

---

## 🛠️ Tech Stack & Architecture

- **Language**: [Kotlin](https://kotlinlang.org/)
- **UI Framework**: Android XML (Layouts, `ConstraintLayout`, `MaterialComponents`)
- **Min SDK**: `30` (Android 11)
- **Target / Compile SDK**: `37`
- **Build System**: Gradle with Kotlin DSL (`build.gradle.kts`)
- **Design Specifications**: 8dp Grid system, dark theme palette, Poppins font family (`UI Design/DESIGN.md`)

---

## 📁 Repository Structure

```
CardClash2P/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/cardclash2p/
│   │       │   └── MainActivity.kt        # Core game state & loop logic
│   │       ├── res/
│   │       │   ├── drawable/              # Card assets (card_0 .. card_9, question_mark_card)
│   │       │   ├── font/                  # Poppins font files
│   │       │   ├── layout/
│   │       │   │   └── activity_main.xml  # Game interface layout
│   │       │   └── values/                # Strings, colors, themes
│   │       └── AndroidManifest.xml
│   └── build.gradle.kts                   # App module build config
├── UI Design/
│   ├── DESIGN.md                          # Design system & color tokens
│   ├── code.html                          # UI web markup preview
│   └── screen.png                         # Screenshot preview
├── video/
│   └── Screen_recording_20260806_173227.webm # Gameplay video
├── build.gradle.kts                       # Root build script
├── settings.gradle.kts                    # Repository & plugin settings
└── README.md                              # Documentation
```

---

## 🚀 Getting Started

### Prerequisites

- [Android Studio](https://developer.android.com/studio) (Hedgehog / Iguana or newer recommended)
- JDK 11 or higher
- Android Device or Emulator running Android 11+ (API Level 30+)

### Building & Running

1. **Clone the repository**:
   ```bash
   git clone https://github.com/M2hmoud2del/mobile-dev-journey.git
   cd android/xml/Day-4/CardClash2P
   ```

2. **Open in Android Studio**:
   - Open Android Studio and select **Open**.
   - Navigate to the `CardClash2P` directory and click **OK**.

3. **Build & Run**:
   - Let Gradle sync dependencies.
   - Select your target emulator/device.
   - Press **Run (Shift + F10)** or build an APK:
     ```bash
     ./gradlew assembleDebug
     ```

---

## 📄 License

This project is part of the **Mobile Dev Journey** series for learning Android Development. Feel free to use and modify for learning purposes.
