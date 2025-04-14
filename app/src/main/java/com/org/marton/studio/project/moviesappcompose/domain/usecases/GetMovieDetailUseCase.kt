package com.org.marton.studio.project.moviesappcompose.domain.usecases

import com.org.marton.studio.project.moviesappcompose.ApiKeyHolder
import com.org.marton.studio.project.moviesappcompose.data.ktor.MovieService
import com.org.marton.studio.project.moviesappcompose.data.ktor.MoviesRepositoryImpl
import com.org.marton.studio.project.moviesappcompose.domain.Movie

class GetMovieDetailUseCase {
    private val apiKey = ApiKeyHolder.getApiKey()
    private val movieService = MovieService.create(apiKey)
    private val repository = MoviesRepositoryImpl(movieService)

    suspend operator fun invoke(id: String): Movie {
        return repository.fetchMovieDetails(id)
    }
}