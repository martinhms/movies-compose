package com.org.marton.studio.project.moviesappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.org.marton.studio.project.moviesappcompose.ui.theme.screens.detail.DetailViewModel
import com.org.marton.studio.project.moviesappcompose.ui.theme.screens.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ApiKeyHolder.initialize(this, R.string.api_key)
        setContent {
            App(homeViewModel = homeViewModel)
        }
    }
}