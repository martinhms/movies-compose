package com.org.marton.studio.project.moviesappcompose.ui.theme.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.org.marton.studio.project.moviesappcompose.domain.Movie
import com.org.marton.studio.project.moviesappcompose.domain.usecases.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
  private val getMovieDetailUseCase: GetMovieDetailUseCase
) : ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    fun loadMovieDetails(id: String) {
        viewModelScope.launch {
            try {
                state = UiState(loading = true)
                val response = getMovieDetailUseCase.invoke(id)
                state = UiState(loading = false, movie = response)
                println("fetching detail detail movie response: $response")
            } catch (e: Exception) {
                println("Error fetching detail ${e.message}")
                state = UiState(loading = false, error = e.message)
            }
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val movie: Movie? = null,
        val error: String? = null
    )
}