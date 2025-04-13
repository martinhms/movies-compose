package com.org.marton.studio.project.moviesappcompose.ui.theme.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.org.marton.studio.project.moviesappcompose.ui.theme.Movie

class DetailViewModel(id: String) : ViewModel() {

    var state by mutableStateOf(UiState())
        private set


    data class UiState(
        val loading: Boolean = false,
        val movie: Movie? = null,
        val error: String? = null
    )
}