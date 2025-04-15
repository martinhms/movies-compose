package com.org.marton.studio.project.moviesappcompose.domain.usecases

import com.org.marton.studio.project.moviesappcompose.data.ServiceFactory
import com.org.marton.studio.project.moviesappcompose.data.ktor.MoviesRepositoryImpl
import com.org.marton.studio.project.moviesappcompose.domain.Movie
import com.org.marton.studio.project.moviesappcompose.domain.MoviesRepository

class GetMovieDetailUseCase {
    private val repository: MoviesRepository =
        MoviesRepositoryImpl(ServiceFactory.createMovieService())

    suspend operator fun invoke(id: String): Movie {
        return repository.fetchMovieDetails(id)
    }
}