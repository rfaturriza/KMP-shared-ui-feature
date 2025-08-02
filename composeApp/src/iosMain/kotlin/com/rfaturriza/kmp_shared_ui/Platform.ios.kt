package com.rfaturriza.kmp_shared_ui

import platform.Foundation.NSBundle
import platform.UIKit.UIDevice
import platform.UIKit.UIApplication
import platform.UIKit.UIWindow
import platform.UIKit.UIWindowScene
import platform.UIKit.UINavigationController

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

actual fun closeCurrentScreen(
    activity: Any?
) {
    val windowScene = UIApplication.sharedApplication.connectedScenes.firstOrNull() as? UIWindowScene
    val window = windowScene?.windows?.firstOrNull() as? UIWindow
    var topVC = window?.rootViewController

    // Traverse to the top-most presented view controller
    while (topVC?.presentedViewController != null) {
        topVC = topVC.presentedViewController
    }

    // Try to pop or dismiss the top view controller if possible
    val nav = topVC as? UINavigationController
    if (nav != null && nav.viewControllers.size > 1) {
        nav.popViewControllerAnimated(true)
    } else {
        topVC?.dismissViewControllerAnimated(true, completion = null)
    }
}

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class ContextFactory {
    // Bundle allows you to lookup resources
    actual fun getContext(): Any = NSBundle
    // UIApplication allows you to access all app info
    actual fun getApplication(): Any = UIApplication
    // RootViewController can be used to identify your current screen
    actual fun getActivity(): Any = UIApplication.sharedApplication.keyWindow?.rootViewController ?: ""
}