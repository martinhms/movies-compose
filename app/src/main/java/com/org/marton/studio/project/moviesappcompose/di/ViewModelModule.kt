package com.org.marton.studio.project.moviesappcompose.di

import com.org.marton.studio.project.moviesappcompose.data.ktor.MovieService
import com.org.marton.studio.project.moviesappcompose.data.ktor.MoviesRepositoryImpl
import com.org.marton.studio.project.moviesappcompose.domain.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.ktor.client.HttpClient

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    fun provideMovieService(httpClient: HttpClient): MovieService {
        return MovieService(httpClient)
    }

    @Provides
    fun provideMoviesRepository(movieService: MovieService): MoviesRepository {
        return MoviesRepositoryImpl(movieService)
    }
}