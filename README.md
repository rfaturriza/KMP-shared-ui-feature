This is a Kotlin Multiplatform (KMP) sample project demonstrating how to add new features using KMP shared UI to an existing legacy codebase. The base code remains your legacy project, and new features are implemented in KMP modules, allowing you to call shared UI from your existing Activities (on Android) or Views (on iOS).

The main idea is to support teams who want to incrementally migrate to KMP by introducing new features as shared modules, while keeping the existing codebase intact. This approach lets you gradually adopt KMP, integrating new multiplatform features without needing to rewrite your entire app.

* [/composeApp](./composeApp/src) contains the shared KMP modules and code for new features.
  - [commonMain](./composeApp/src/commonMain/kotlin) is for code that’s common for all targets.
  - Platform-specific folders (e.g., [androidMain], [iosMain]) are for code that will only be compiled for the respective platform. Here you can bridge between your legacy Activities or Views and the new KMP features.

* [/iosApp](./iosApp/iosApp) contains the iOS application entry point. You can integrate new KMP features into your existing UIKit or SwiftUI code here.

This structure is ideal for teams with a legacy codebase who want to add new features using KMP, enabling a smooth and incremental migration path to multiplatform development.

## How It Works

This project demonstrates how to incrementally migrate a legacy codebase to Kotlin Multiplatform (KMP) by adding new features as shared modules. The legacy code (your existing Android Activities or iOS Views) remains the entry point, and you can launch new KMP-based UI/features from there. This allows you to:

- Keep your current codebase unchanged for existing features.
- Add new features in KMP modules, sharing UI and logic across Android and iOS.
- Call KMP UI from your legacy Android Activity or iOS ViewController/SwiftUI View.

### Typical Flow
1. User navigates to a legacy Activity (Android) or ViewController (iOS).
2. The legacy screen launches a new feature implemented in KMP (e.g., by starting a Compose-based Activity or presenting a ComposeViewController).
3. The shared KMP code runs, providing a multiplatform UI and logic.

## Sample Code

### Android: Launching a KMP Feature from a Legacy Activity
```kotlin
// In your legacy Android Activity
val intent = Intent(this, KmpFeatureActivity::class.java)
startActivity(intent)
```

```kotlin
// KmpFeatureActivity.kt
class KmpFeatureActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SharedKmpFeatureUI()
        }
    }
}
```

### iOS: Launching a KMP Feature from a Legacy ViewController
```swift
// In your legacy iOS ViewController
import shared // Import your KMP framework

let composeVC = ComposeViewControllerKt.SharedKmpFeatureUIController()
self.present(composeVC, animated: true, completion: nil)
```

---

This approach lets you keep your legacy codebase as the foundation, while new features are built in KMP and shared across platforms.

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…