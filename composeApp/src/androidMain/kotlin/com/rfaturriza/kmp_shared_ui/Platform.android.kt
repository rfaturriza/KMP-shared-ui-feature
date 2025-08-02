package com.rfaturriza.kmp_shared_ui

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.os.Build
import androidx.activity.ComponentActivity
import kotlin.system.exitProcess

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual fun closeCurrentScreen(
    activity: Any?
) {
    if (activity is Activity) {
        // Close the current activity
        activity.finish()
    } else {
        // If not an Activity, we can exit the app
        if (activity !is Context) return
        val activityManager = activity.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.clearApplicationUserData()
        exitProcess(0)
    }
}

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class ContextFactory(private val activity: ComponentActivity) {
    actual fun getContext(): Any = activity.baseContext
    actual fun getApplication(): Any = activity.application
    actual fun getActivity(): Any = activity
}