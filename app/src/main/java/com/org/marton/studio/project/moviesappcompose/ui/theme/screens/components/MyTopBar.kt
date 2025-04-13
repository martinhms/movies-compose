package com.org.marton.studio.project.moviesappcompose.ui.theme.screens.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.org.marton.studio.project.moviesappcompose.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    title: String? = null,
    navIcon: Boolean = true,
    onBackClick: () -> Unit,
    firstAction: Boolean = false,
    onSettingsClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(title ?: stringResource(R.string.app_name))
        },
        navigationIcon = {
            if (navIcon) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        },
        actions = {
            if (firstAction) {
                IconButton(onClick = onSettingsClick) {
                    Icon(
                        imageVector = Icons.Filled.Call,
                        contentDescription = "Settings"
                    )
                }
            }

        }
    )
}