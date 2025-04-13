package com.org.marton.studio.project.moviesappcompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.org.marton.studio.project.moviesappcompose.ui.theme.navigation.NavigationCompose

@Composable
@Preview
fun App() {
    val apiKey = stringResource(R.string.api_key)
    NavigationCompose()
}