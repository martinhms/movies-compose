package com.org.marton.studio.project.moviesappcompose.data.ktor

import com.org.marton.studio.project.moviesappcompose.data.DetailMovieResponse
import com.org.marton.studio.project.moviesappcompose.data.MovieResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class MovieService(
    private val client: HttpClient
) {
    suspend fun getPopularMovies(): MovieResponse {
        val url = "/3/movie/popular"
        return client.get(url).body<MovieResponse>()
    }

    suspend fun fetchMovieDetails(id: String): DetailMovieResponse {
        val url = "/3/movie/$id"
        return client.get(url).body<DetailMovieResponse>()
    }

    companion object {
        fun create(apiKey: String): MovieService {
            val client = HttpClient {
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
                        parameters.append("api_key", apiKey)
                    }
                }
            }
            return MovieService(client)
        }
    }
}