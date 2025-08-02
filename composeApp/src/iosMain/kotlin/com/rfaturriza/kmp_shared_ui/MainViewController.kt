package com.rfaturriza.kmp_shared_ui

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController { AppComposeNavigation(
    platformContext = ContextFactory()
) }