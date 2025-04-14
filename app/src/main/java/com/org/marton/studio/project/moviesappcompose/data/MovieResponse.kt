package com.org.marton.studio.project.moviesappcompose.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    @SerialName("page") val page: Int? = null,
    @SerialName("results") val results: List<DetailMovieResponse>? = null,
    @SerialName("total_pages") val totalPages: Int? = null,
    @SerialName("total_results") val totalResults: Int? = null
)

