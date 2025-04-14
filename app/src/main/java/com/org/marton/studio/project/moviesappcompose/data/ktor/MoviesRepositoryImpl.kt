package com.org.marton.studio.project.moviesappcompose.data.ktor

import com.org.marton.studio.project.moviesappcompose.data.DetailMovieResponse
import com.org.marton.studio.project.moviesappcompose.domain.Movie
import com.org.marton.studio.project.moviesappcompose.domain.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val moviesService: MovieService) : MoviesRepository {
    override suspend fun fetchPopularMovies(): List<Movie> {
        return moviesService.getPopularMovies().results?.map { it.toDomainMovie() } ?: emptyList()
    }

    override suspend fun fetchMovieDetails(id: String): Movie {
        return moviesService.fetchMovieDetails(id).toDomainMovie()
    }

    private fun DetailMovieResponse.toDomainMovie() = Movie(
        id = id,
        title = title,
        poster = if (posterPath != null) "https://image.tmdb.org/t/p/w185/$posterPath" else "",
        overview = overview,
        releaseNote = releaseDate,
        backdrop = backdropPath?.let { "https://image.tmdb.org/t/p/w780/$it" } ?: "",
        originalTitle = originalTitle,
        originalLanguage = originalLanguage,
        popularity = popularity,
        voteAverage = voteAverage,
    )
}