package com.rfaturriza.kmp_shared_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(
    onBackPressed: () -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Second Screen",
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackPressed
                    ) {
                        Text(
                            text = "Back",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            )
        },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = onBackPressed
            ) {
                Text("Back to First Screen")
            }
        }
    }
}