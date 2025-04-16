package com.org.marton.studio.project.moviesappcompose.domain

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val releaseNote: String,
    val poster: String,
    val backdrop: String?,
    val originalTitle: String,
    val originalLanguage: String,
    val popularity: Double,
    val voteAverage: Double,
)
