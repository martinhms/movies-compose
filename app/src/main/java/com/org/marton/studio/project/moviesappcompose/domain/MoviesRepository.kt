package com.org.marton.studio.project.moviesappcompose.domain

interface MoviesRepository {
    suspend fun fetchPopularMovies(): List<Movie>
    suspend fun fetchMovieDetails(id: String): Movie
}
