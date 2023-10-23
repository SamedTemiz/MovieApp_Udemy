package com.samedtemiz.movieapp_udemy.presentation.movie_details

import com.samedtemiz.movieapp_udemy.domain.model.MovieDetail

data class MovieDetailsState(
    val isLoading: Boolean = false,
    val movie: MovieDetail? = null,
    val error : String = ""
)