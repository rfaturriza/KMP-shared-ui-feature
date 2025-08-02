package com.rfaturriza.kmp_shared_ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun AppComposeNavigation(
    platformContext: ContextFactory // Injecting Context from all platforms
) {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(
            route = "root",
            navController = navController,
            startDestination = "home",
        ) {
            composable("home") {
                FirstScreen(
                    onBackPressed = { closeCurrentScreen(
                        activity = platformContext.getActivity()
                    ) },
                    onNavigateToSecondScreen = { navController.navigate("second") }
                )
            }
            composable("second") {
                SecondScreen(
                    onBackPressed = { navController.navigateUp() }
                )
            }
        }
    }
}