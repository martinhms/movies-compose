package com.org.marton.studio.project.moviesappcompose.ui.theme.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.org.marton.studio.project.moviesappcompose.domain.Movie
import com.org.marton.studio.project.moviesappcompose.domain.usecases.GetMovieDetailUseCase
import kotlinx.coroutines.launch

class DetailViewModel(id: String) : ViewModel() {

    private val getMovieDetailUseCase = GetMovieDetailUseCase()
    var state by mutableStateOf(UiState())
        private set

    init {
        viewModelScope.launch {
            try {
                state = UiState(loading = true)
                val response = getMovieDetailUseCase.invoke(id)
                state = UiState(loading = false, movie = response)
                println("fetching detail detail movie response: $response")
            } catch (e: Exception) {
                println("Error fetching detail ${e.message}")
                state =UiState(loading = false, error = e.message)
            }
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val movie: Movie? = null,
        val error: String? = null
    )
}