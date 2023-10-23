package com.samedtemiz.movieapp_udemy.presentation.movies

sealed class MoviesEvent{
    data class Search(val searchString: String) : MoviesEvent()
}
