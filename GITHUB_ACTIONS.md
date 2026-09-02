# GitHub Actions Workflow - Build Configuration

This workflow automatically builds the Agenda Médica Android APK using GitHub Actions.

## Workflow File
- Location: `.github/workflows/build.yml`
- Trigger: Push to `main`/`develop` or Pull Request
- Java Version: 21 (Temurin distribution)
- Gradle: 8.7 with Kotlin DSL

## Workflow Stages

### 1. Checkout
- Uses `actions/checkout@v4`
- Pulls the latest code from the branch

### 2. Setup JDK 21
- Uses `actions/setup-java@v4`
- Configures Java 21 (Temurin)
- Enables Gradle caching for faster builds

### 3. Gradle Build
- Executes `./gradlew assembleDebug`
- Produces `app-debug.apk` with full debugging capabilities
- Suitable for testing and development

### 4. Artifact Upload
- Uses `actions/upload-artifact@v4`
- Uploads debug APK to GitHub Actions artifacts
- Available for download for 90 days

### 5. Release Build (Optional)
- Executes `./gradlew assembleRelease`
- Uses `continue-on-error: true` to allow build to succeed even if release build fails
- Release APK also uploaded if successful

## Output Artifacts

- **Debug APK**: `AgendaMedica-debug` (includes full debugging symbols)
- **Release APK**: `AgendaMedica-release` (optimized, requires signing key)

## Usage

### Automatic Builds
- Workflow runs automatically on:
  - Push to `main` or `develop`
  - Pull requests to `main` or `develop`

### Manual Trigger
1. Go to Actions tab in GitHub repository
2. Select "Build Android APK"
3. Click "Run workflow"
4. Monitor build progress in real-time

### Downloading APKs
1. Navigate to the completed workflow run
2. Scroll to "Artifacts" section
3. Download `AgendaMedica-debug.zip`
4. Extract and install APK on Android device/emulator

## Debugging Workflow Issues

### Check Workflow Logs
1. Go to Actions → Select workflow run
2. Click on "build" job
3. Expand steps to see detailed logs

### Common Issues

**Issue**: Java version error
- **Solution**: Verify Gradle config uses Java 21 syntax

**Issue**: Gradle cache not working
- **Solution**: Clear GitHub Actions cache if build seems stale

**Issue**: Missing Android SDK components
- **Solution**: The Gradle wrapper automatically downloads required SDK components

## Security Considerations

1. **No Signing Key Required**: Debug APKs don't require a keystore
2. **For Release Builds**: Add signing configuration to `build.gradle.kts`
3. **Secrets Management**: Use GitHub Secrets for keystore credentials

## Performance

- **First Build**: ~5-10 minutes (downloads dependencies)
- **Subsequent Builds**: ~2-3 minutes (uses Gradle cache)

---

For modifications to the workflow, edit `.github/workflows/build.yml`
