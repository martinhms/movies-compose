package com.org.marton.studio.project.moviesappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ApiKeyHolder.initialize(this, R.string.api_key)
        setContent {
            App()
        }
    }
}