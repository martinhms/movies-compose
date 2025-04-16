package com.org.marton.studio.project.moviesappcompose.data

import com.org.marton.studio.project.moviesappcompose.ApiKeyHolder
import com.org.marton.studio.project.moviesappcompose.data.ktor.MovieService

object ServiceFactory {
    fun createMovieService(): MovieService {
        val apiKey = ApiKeyHolder.getApiKey()
        return MovieService.create(apiKey)
    }
}