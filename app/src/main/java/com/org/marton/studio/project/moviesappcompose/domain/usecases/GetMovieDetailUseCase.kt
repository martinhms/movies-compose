package com.org.marton.studio.project.moviesappcompose.domain.usecases

import com.org.marton.studio.project.moviesappcompose.domain.Movie
import com.org.marton.studio.project.moviesappcompose.domain.MoviesRepository
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: MoviesRepository) {
    suspend operator fun invoke(id: String): Movie {
        return repository.fetchMovieDetails(id)
    }
}