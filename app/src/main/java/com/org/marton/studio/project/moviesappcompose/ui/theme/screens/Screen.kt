package com.org.marton.studio.project.moviesappcompose.ui.theme.screens

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Screen(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    MaterialTheme {
        Surface(
            modifier = modifier,
            content = content
        )
    }
}