package com.org.marton.studio.project.moviesappcompose

import androidx.compose.runtime.Composable
import com.org.marton.studio.project.moviesappcompose.ui.theme.navigation.NavigationCompose
import com.org.marton.studio.project.moviesappcompose.ui.theme.screens.home.HomeViewModel

@Composable
fun App(homeViewModel: HomeViewModel) {
    NavigationCompose(homeViewModel = homeViewModel)
}