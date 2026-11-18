# WeatherApp

WeatherApp is a Kotlin Multiplatform and Compose Multiplatform application that
shows the current temperature for the device's location. The shared Compose UI
is used on Android, iOS, and Desktop, while each platform supplies its own
location implementation.

## Features

- Detects the current location on each supported platform.
- Fetches the current temperature in Celsius from
  [WeatherAPI](https://www.weatherapi.com/).
- Displays a loading state while location or weather data is being retrieved.
- Reports location and network errors in the UI.
- Uses adaptive Material 3 and Cupertino-style controls where supported.

## Supported platforms

| Platform | Location source | Entry point |
| --- | --- | --- |
| Android | Google Play Services fused location provider | [`MainActivity.kt`](androidApp/src/main/kotlin/com/gedo0x/weatherapp/MainActivity.kt) |
| iOS | Compass geolocation APIs | [`MainViewController.kt`](shared/src/iosMain/kotlin/com/gedo0x/weatherapp/MainViewController.kt) |
| Desktop (JVM) | Approximate IP-based location from `ip-api.com` | [`main.kt`](desktopApp/src/main/kotlin/com/gedo0x/weatherapp/main.kt) |

## Technology stack

- Kotlin Multiplatform
- Compose Multiplatform
- Material 3 and adaptive Cupertino UI
- Ktor HTTP client
- Kotlinx Serialization
- Kotlin Coroutines
- Gradle 9.5.1
- JVM target 11

## Project structure

```text
.
├── androidApp/       Android application and launcher activity
├── desktopApp/       Desktop JVM application
├── iosApp/            Native iOS application wrapper
├── shared/
│   └── src/
│       ├── commonMain/  Shared UI, models, and WeatherAPI client
│       ├── androidMain/ Android location implementation
│       ├── iosMain/     iOS location implementation and view controller
│       └── jvmMain/     Desktop location implementation
└── gradle/            Gradle wrapper and version catalog
```

## Requirements

- JDK 11 or newer
- Android Studio with the Android SDK and an Android emulator or device
- Xcode for building and running the iOS app
- A network connection for location and weather requests

Android builds use compile SDK 37 and require Android API level 30 or newer.

## Running the project

Clone the repository and open this directory in Android Studio or IntelliJ IDEA.
The Gradle wrapper can also be used from a terminal.

### Android

Build the debug APK:

```bash
./gradlew :androidApp:assembleDebug
```

Install and run on a connected device or emulator from Android Studio. Allow
location access when prompted; the app needs location access to enable the
temperature request.

### Desktop

Run the desktop application:

```bash
./gradlew :desktopApp:run
```

For Compose hot reload during development:

```bash
./gradlew :desktopApp:hotRun --auto
```

Desktop location is estimated from the public IP address, so it may be less
precise than the mobile platform implementations.

### iOS

Open [`iosApp`](iosApp) in Xcode, select an iOS simulator or connected device,
and run the `iosApp` scheme. The iOS app uses the shared framework and declares
the required location usage descriptions in
[`Info.plist`](iosApp/iosApp/Info.plist).

## WeatherAPI configuration

The shared client is implemented in
[`WeatherAPI.kt`](shared/src/commonMain/kotlin/com/gedo0x/weatherapp/api/WeatherAPI.kt).
It calls WeatherAPI's current-weather endpoint with latitude and longitude
coordinates.

For local development, provide a valid WeatherAPI key in the client
configuration before running the app. Do not commit API keys to source control;
for production, move the key to a secure build-time or runtime configuration
mechanism.

## Testing and verification

Run the Gradle verification tasks with:

```bash
./gradlew check
```

## License

No license has been specified for this project yet.
