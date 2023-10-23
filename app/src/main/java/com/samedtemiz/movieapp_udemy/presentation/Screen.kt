package com.samedtemiz.movieapp_udemy.presentation

sealed class Screen(val route: String){

    data object MovieScreen: Screen(route = "movie_screen")
    data object MovieDetailScreen: Screen(route = "movie_detail_screen")

}
