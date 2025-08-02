package com.rfaturriza.kmp_shared_ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun AppVoyagerNavigation(
    platformContext: ContextFactory // Injecting Context from all platforms
) {
    MaterialTheme {
        Navigator(FirstScreen(platformContext))
    }
}

data class FirstScreen(
    val platformContext: ContextFactory // Injecting Context from all platforms
) : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        FirstScreen(
            onBackPressed = {
                closeCurrentScreen(
                    activity = platformContext.getActivity()
                )
            },
            onNavigateToSecondScreen = {
                navigator.push(SecondScreen)
            }
        )
    }
}

object SecondScreen : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        SecondScreen(
            onBackPressed = {
                navigator.pop()
            }
        )
    }
}