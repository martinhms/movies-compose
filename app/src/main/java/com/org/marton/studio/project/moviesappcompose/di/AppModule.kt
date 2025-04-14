package com.org.marton.studio.project.moviesappcompose.di

import com.org.marton.studio.project.moviesappcompose.ApiKeyHolder
import com.org.marton.studio.project.moviesappcompose.data.ktor.MovieService
import com.org.marton.studio.project.moviesappcompose.data.ktor.MoviesRepositoryImpl
import com.org.marton.studio.project.moviesappcompose.domain.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideMovieService(): MovieService {
        val apiKey = ApiKeyHolder.getApiKey()
        return MovieService.create(apiKey)
    }

    @Provides
    fun provideMoviesRepository(movieService: MovieService): MoviesRepository {
        return MoviesRepositoryImpl(movieService)
    }
}