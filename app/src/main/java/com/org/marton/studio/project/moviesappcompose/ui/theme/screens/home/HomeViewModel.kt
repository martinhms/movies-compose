package com.org.marton.studio.project.moviesappcompose.ui.theme.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.org.marton.studio.project.moviesappcompose.domain.Movie
import com.org.marton.studio.project.moviesappcompose.domain.usecases.GetMoviesUseCase
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel() {

    private val getMoviesUseCase = GetMoviesUseCase()
    var state by mutableStateOf(UiState())
        private set

    init {
        viewModelScope.launch {
            try {
                state = UiState(loading = true)
                val response = getMoviesUseCase.invoke()
                state = UiState(loading = false, movies = response)
                println("fetching movies response: $response")
            } catch (e: Exception) {
                println("Error fetching movies ${e.message}")
                state = UiState(loading = false, error = e.message)
            }
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val movies: List<Movie> = emptyList(),
        val error: String? = null
    )
}
