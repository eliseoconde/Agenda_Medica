# Agenda Médica - Setup Guide

## Project Overview
**Agenda Médica** is an Android application for managing medical appointments with a monthly calendar view and color-coded appointment status.

### Features
- 📅 Monthly calendar view
- 🎨 Color-coded dates:
  - **Yellow**: Past appointments
  - **Red**: Current date
  - **Green**: Future appointments
- ➕ Add new appointments
- ✏️ Edit existing appointments  
- 🗑️ Delete appointments
- 📝 Appointment fields: date, time, medical center, specialty, observations

## Tech Stack
- **Language**: Kotlin 2.0.21
- **UI Framework**: Jetpack Compose
- **Database**: Room (SQL)
- **Build System**: Gradle 8.7 with Kotlin DSL
- **Target SDK**: Android 35 (API level 35)
- **Min SDK**: Android 7.4 (API level 24)
- **Java**: OpenJDK 21
- **CI/CD**: GitHub Actions

## Project Structure

```
AgendaMedica/
├── .github/
│   └── workflows/
│       └── build.yml                 # GitHub Actions workflow
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── AndroidManifest.xml
│   │   │   ├── java/
│   │   │   │   └── com/example/agendamedica/
│   │   │   │       ├── MainActivity.kt
│   │   │   │       └── ui/theme/
│   │   │   │           └── Theme.kt
│   │   │   └── res/
│   │   │       └── values/
│   │   │           ├── strings.xml
│   │   │           └── themes.xml
│   │   ├── test/          # Unit tests
│   │   └── androidTest/   # Instrumented tests
│   ├── build.gradle.kts   # App module build configuration
│   └── proguard-rules.pro # ProGuard configuration
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── build.gradle.kts       # Root project build configuration
├── settings.gradle.kts    # Project structure
├── gradle.properties      # Gradle properties
├── gradlew               # Unix/Linux Gradle wrapper
├── gradlew.bat           # Windows Gradle wrapper
├── .gitignore            # Git ignore rules
└── README.md             # Project description
```

## Prerequisites

### Local Development
1. **Android Studio** (latest version)
2. **Java/JDK 21** (or later)
3. **Android SDK** (API level 35)
4. **Gradle 8.7** (included via wrapper)

### GitHub Actions
- Java 21 (set up automatically)
- Gradle wrapper (included in repository)

## Building the Project

### Local Build

#### Windows:
```bash
gradlew.bat assembleDebug
```

#### macOS/Linux:
```bash
./gradlew assembleDebug
```

### Building Release APK

```bash
gradlew assembleRelease
```

### Outputs
- **Debug APK**: `app/build/outputs/apk/debug/app-debug.apk`
- **Release APK**: `app/build/outputs/apk/release/app-release.apk`

## GitHub Actions Workflow

The `.github/workflows/build.yml` automatically builds APKs when:
1. Code is pushed to `main` or `develop` branch
2. Pull requests are created for `main` or `develop`
3. Manually triggered via "Run workflow" button

### Workflow Steps
1. Checks out the code
2. Sets up JDK 21
3. Runs Gradle debug build
4. Uploads debug APK as artifact
5. Attempts release build (optional)

### Downloading Built APKs
1. Go to Actions tab in GitHub
2. Select the successful workflow run
3. Download the `AgendaMedica-debug` artifact
4. Extract the APK file

## Dependencies

### AndroidX/Jetpack
- `androidx.core:core-ktx:1.15.0`
- `androidx.lifecycle:lifecycle-runtime-ktx:2.8.7`
- `androidx.activity:activity-compose:1.9.3`
- `androidx.appcompat:appcompat:1.7.0`

### Compose
- `androidx.compose.ui:ui`
- `androidx.compose.material3:material3`

### Database
- `androidx.room:room-runtime:2.6.1`

### Testing
- `junit:junit:4.13.2`
- `androidx.test.ext:junit:1.2.1`
- `androidx.test.espresso:espresso-core:3.6.1`

## Configuration

### Gradle Build Properties (`gradle.properties`)
```properties
org.gradle.jvmargs=-Xmx2048m    # Max heap size
android.useAndroidX=true         # Use AndroidX libraries
kotlin.code.style=official       # Kotlin code style
```

### Java 21 Configuration
Both the root and app modules are configured for Java 21:
- `sourceCompatibility = JavaVersion.VERSION_21`
- `targetCompatibility = JavaVersion.VERSION_21`
- `jvmTarget = "21"`

## Troubleshooting

### Build Fails with Gradle Issues
```bash
# Clean build
gradlew clean build
```

### Java Version Mismatch
Ensure your JAVA_HOME points to JDK 21:
```bash
java -version  # Should show version 21
```

### Android SDK Issues
In Android Studio:
1. Go to Tools → SDK Manager
2. Ensure API 35 is installed
3. Run `./gradlew --version` to verify Gradle setup

## Next Steps

1. **Implement Calendar View**: Create the calendar UI with Jetpack Compose
2. **Add Room Database**: Set up appointment data persistence
3. **Implement Appointment CRUD**: Add/edit/delete appointment functionality
4. **Add Notifications**: Set up appointment reminders
5. **Create Tests**: Add unit and instrumented tests
6. **Optimize APK**: Implement ProGuard/R8 code shrinking

## Contributing

1. Create a feature branch: `git checkout -b feature/your-feature`
2. Make your changes
3. Push to GitHub: `git push origin feature/your-feature`
4. Create a Pull Request

## License

This project is open source and available for educational purposes.

---

**Last Updated**: September 2026
**Version**: 1.0
**Status**: Base setup complete, ready for feature development
