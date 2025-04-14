package com.org.marton.studio.project.moviesappcompose.di

import com.org.marton.studio.project.moviesappcompose.ApiKeyHolder
import com.org.marton.studio.project.moviesappcompose.data.ktor.MovieService
import com.org.marton.studio.project.moviesappcompose.data.ktor.MoviesRepositoryImpl
import com.org.marton.studio.project.moviesappcompose.domain.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideHttpClient(): HttpClient {
        return HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    coerceInputValues = true
                })
            }
            install(DefaultRequest) {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "api.themoviedb.org"
                    parameters.append("api_key", ApiKeyHolder.getApiKey())
                }
            }
        }
    }

    @Provides
    fun provideMovieService(httpClient: HttpClient): MovieService {
        return MovieService(httpClient)
    }

    @Provides
    fun provideMoviesRepository(movieService: MovieService): MoviesRepository {
        return MoviesRepositoryImpl(movieService)
    }
}