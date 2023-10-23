package com.samedtemiz.movieapp_udemy.domain.model

import com.samedtemiz.movieapp_udemy.data.remote.dto.Rating

data class MovieDetail(
    val Actors: String,
    val Awards: String,
    val Country: String,
    val Director: String,
    val Genre: String,
    val Language: String,
    val Poster: String,
    val Rated: String,
    val Released: String,
    val Title: String,
    val Type: String,
    val Year: String,
    val imdbRating: String,
)