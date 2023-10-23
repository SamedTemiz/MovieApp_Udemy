package com.samedtemiz.movieapp_udemy.presentation.movies

import com.samedtemiz.movieapp_udemy.domain.model.Movie

data class MoviesState(
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error: String = "",
    val search: String = "Batman"
)