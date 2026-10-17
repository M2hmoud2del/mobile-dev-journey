# Notes App

A small Android notes application built with Kotlin and Jetpack Compose. Notes are
stored locally with Room and remain available after the app is closed.

## Features

- View saved notes on the home screen.
- Create a note with the floating action button.
- Tap a note to edit it.
- Update or delete an existing note.
- Store note data in a local Room database.
- Use Compose previews for the main note screens.

## Tech stack

- Kotlin
- Jetpack Compose and Material 3
- AndroidX Activity, Lifecycle, and ViewModel
- Room with Kotlin Symbol Processing (KSP)
- Bundled SQLite driver
- JUnit 4
- AndroidX Instrumentation and Compose test libraries

## Project structure

```text
app/src/main/java/com/maadcoding/notesapp/
├── database/
│   ├── Note.kt             # Room entity and Parcelable model
│   ├── NoteDao.kt          # Database operations
│   └── RoomDBHelper.kt     # Room database singleton
├── ui/activity/
│   ├── MainActivity.kt     # Note list and navigation to note screens
│   ├── AddNoteActivity.kt  # Create a note
│   └── EditNoteActivity.kt # Update or delete a note
└── ui/viewmodel/
    └── NoteViewModel.kt    # Database actions scoped to the UI lifecycle
```

Tests are located under:

```text
app/src/test/        # Local JVM tests
app/src/androidTest/ # Tests requiring Android framework components
```

## Requirements

- Android Studio with Android SDK support
- JDK 17
- Android SDK platform 37
- An Android emulator or physical device for instrumented tests

The app supports Android API 24 and newer. The project uses the Gradle wrapper,
so a separate Gradle installation is not required.

## Getting started

1. Clone the repository and open this `Starter` directory in Android Studio.
2. Allow Android Studio to sync the Gradle project and install any missing SDK
   components.
3. Select an emulator or connected Android device.
4. Run the `app` configuration, or use the command line:

   ```bash
   ./gradlew installDebug
   ```

On Windows, use `gradlew.bat` instead of `./gradlew`.

## Testing

### Run local JVM tests

These tests run on the development machine and do not require an emulator:

```bash
./gradlew test
```

The local test source set currently contains the default JUnit verification
test in `app/src/test`.

### Run instrumented Android tests

Start an emulator or connect a physical Android device, then run:

```bash
./gradlew connectedAndroidTest
```

`NoteDaoTest` uses an in-memory Room database and verifies that notes can be
inserted, read, updated, and deleted. The default instrumentation test also
checks the Android application context.

### Run all verification tasks

To run the local tests, compile checks, and connected Android tests when a
device is available:

```bash
./gradlew check connectedAndroidTest
```

Test reports are generated under:

```text
app/build/reports/tests/
app/build/outputs/androidTest-results/
```

## Building a release APK

Build the release variant with:

```bash
./gradlew assembleRelease
```

The generated APK is written to
`app/build/outputs/apk/release/`.

## Data and privacy

Notes are stored locally in the app's Room database (`note_db`). This project
does not define a network permission or a remote synchronization service.

## License

No license has been specified for this project yet.
